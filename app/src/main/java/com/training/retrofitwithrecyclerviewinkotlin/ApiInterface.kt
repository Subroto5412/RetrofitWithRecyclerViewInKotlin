package com.training.retrofitwithrecyclerviewinkotlin

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("volley_array.json")
    fun getPictures(): Call<List<Picture>>
}
