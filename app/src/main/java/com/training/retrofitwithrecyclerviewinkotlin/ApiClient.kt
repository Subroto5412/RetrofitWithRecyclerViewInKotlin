package com.training.retrofitwithrecyclerviewinkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    var BASE_URL = "http://velmm.com/apis/"

    public var retrofit: Retrofit? = null

    public fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}