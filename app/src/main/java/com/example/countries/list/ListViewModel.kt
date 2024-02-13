package com.example.countries.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.ListRepository

class ListViewModel:ViewModel() {
    private val _countries = MutableLiveData<Set<String>>()
    val countries: LiveData<Set<String>> get() = _countries

    private val listRepository = ListRepository()

    init {
        loadCountries()
    }

    private fun loadCountries() {
        _countries.value = listRepository.getCountries() ?: emptySet()
    }

}