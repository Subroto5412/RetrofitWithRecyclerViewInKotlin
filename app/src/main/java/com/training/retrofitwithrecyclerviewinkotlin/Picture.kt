package com.training.retrofitwithrecyclerviewinkotlin

import com.google.gson.annotations.SerializedName

class Picture(title: String, image: String) {
    @SerializedName("title")
    var title: String

    @SerializedName("image")
    var image: String

    init {
        this.title = title
        this.image = image
    }
}