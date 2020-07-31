package com.training.retrofitwithrecyclerviewinkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.my_recycler_view)
        customAdapter = CustomAdapter(this)
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = customAdapter

        var apiInterface: ApiInterface =
            ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getPictures().enqueue(object : Callback<List<Picture>> {
            override fun onResponse(
                call: Call<List<Picture>>?,
                response: Response<List<Picture>>?
            ) {

                if (response?.body() != null)
                    customAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Picture>>?, t: Throwable?) {

            }
        })
    }

}