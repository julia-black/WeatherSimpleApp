package com.juliablack.weathersimpleapp.cities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juliablack.domain.model.City
import com.juliablack.domain.usecases.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val useCase: GetCitiesUseCase
) : ViewModel() {

    val liveCities = MutableLiveData<List<City>>()

    var disposable : Disposable? = null

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
    fun getCities(query: String) {
        disposable = useCase.invoke(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveCities.value = it
            }, {
                liveCities.value = listOf()
            })
    }
}