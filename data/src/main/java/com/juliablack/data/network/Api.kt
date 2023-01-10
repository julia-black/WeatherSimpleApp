package com.juliablack.data.network

import com.juliablack.domain.model.City
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("v1/search.json")
    fun getCities(@Query("q") query: String, @Query("key") key: String): Single<List<City>>
}