package com.example.retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/everything?domains=wsj.com&apiKey=API_KEY
// https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "0796e1e2b6c94e63851629ea691eb3ea"

interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country : String,@Query("page") page : Int) : Call<News>

/* how it takes
    https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1 */
}

// creating retrofit object as singleton

object NewsService{
    val newsInstance: NewsInterface
    init {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        newsInstance =retrofit.create(NewsInterface::class.java)

    }
}


