package com.example.questionapp

import android.app.Service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceGen{
    private var client=OkHttpClient.Builder().build()
    private val retrofit=Retrofit.Builder()

         .baseUrl("https://script.googleusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun<T>buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}