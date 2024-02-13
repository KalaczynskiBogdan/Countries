package com.example.countries.main

import androidx.lifecycle.ViewModel
import com.example.countries.ListRepository

class MainViewModel: ViewModel() {
    private val listRepository = ListRepository()

    fun init(){
        val set: MutableSet<String> = mutableSetOf()
        set.add("USA")
        set.add("Ukraine")
        set.add("Poland")
        set.add("Germany")
        set.add("Canada")
        saveCountries(set)
    }

    private fun saveCountries(set: Set<String>) {
        listRepository.addCountries(set)
    }
}