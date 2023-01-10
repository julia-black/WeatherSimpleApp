package com.juliablack.data.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun createApi(client: OkHttpClient, gson: Gson): Api = Retrofit
    .Builder()
    .client(client)
    .baseUrl("https://api.weatherapi.com/")
    .addConverterFactory(GsonConverterFactory.create(gson))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
    .create(Api::class.java)

fun createGson(): Gson = GsonBuilder()
    .setLenient()
    .create()

fun createOkHttpClient(): OkHttpClient = OkHttpClient
    .Builder()
    .build()

fun createKey() = "4828205ef3e64ffdaae144947212404"