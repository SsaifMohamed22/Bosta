package com.example.bosta.VIEWMODEL

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bosta.MODELS.City
import com.example.bosta.REPOSITORY.CityRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
class CityViewModel(private val repository: CityRepository) : ViewModel() {

    private val _cities = MutableLiveData<List<City>>()
    val cities: LiveData<List<City>> = _cities

    fun loadCities() {
        viewModelScope.launch {
            repository.getCities()?.let {
                _cities.postValue(it)
            }
        }
    }

    fun filterCities(query: String) {
        val filtered = _cities.value?.filter {
            it.cityName.contains(query, true) ||
                    it.districts.any { d ->
                        d.districtName.contains(query, true) || d.districtOtherName.contains(query, true)
                    }
        }
        _cities.postValue(filtered ?: listOf())
    }
}

class CityViewModelFactory(private val repository: CityRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            return CityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
