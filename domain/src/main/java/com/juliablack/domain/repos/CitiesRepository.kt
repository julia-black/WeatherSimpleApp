package com.juliablack.domain.repos

import com.juliablack.domain.model.City
import io.reactivex.Single

interface CitiesRepository {
    fun getCities(query: String) : Single<List<City>>
}