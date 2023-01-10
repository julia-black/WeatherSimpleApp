package com.juliablack.weathersimpleapp.di

import com.juliablack.data.CitiesRepositoryImpl
import com.juliablack.data.network.createApi
import com.juliablack.data.network.createGson
import com.juliablack.data.network.createKey
import com.juliablack.data.network.createOkHttpClient
import com.juliablack.domain.repos.CitiesRepository
import com.juliablack.domain.usecases.GetCitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {
    @Provides
    fun provideRepository(): CitiesRepository = CitiesRepositoryImpl(
        createApi(
            createOkHttpClient(), createGson()
        ),
        provideKey()
    )

    @Provides
    fun provideUseCase(): GetCitiesUseCase = GetCitiesUseCase(provideRepository())

    @Provides
    fun provideKey() = createKey()
}