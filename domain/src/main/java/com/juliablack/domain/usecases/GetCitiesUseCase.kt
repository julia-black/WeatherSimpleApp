package com.juliablack.domain.usecases

import com.juliablack.domain.repos.CitiesRepository

class GetCitiesUseCase(private val repository: CitiesRepository) {
    fun invoke(query: String) = repository.getCities(query)
}