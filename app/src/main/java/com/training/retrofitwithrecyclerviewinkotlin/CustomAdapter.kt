package com.training.retrofitwithrecyclerviewinkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CustomAdapter(val context: Context) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    var movieList: List<Picture> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvMovieName.text = movieList.get(position).title
        Glide.with(context).load(movieList.get(position).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movieList: List<Picture>) {
        this.movieList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.title)
        val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}