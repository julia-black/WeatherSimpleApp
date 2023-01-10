package com.juliablack.data

import com.juliablack.data.network.Api
import com.juliablack.domain.repos.CitiesRepository

class CitiesRepositoryImpl(private val api: Api, private val key: String) : CitiesRepository {
    override fun getCities(query: String) = api.getCities(query, key)
}