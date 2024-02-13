package com.example.countries


class ListRepository {

    fun getCountries(): Set<String>? {
        return App.sharedPreferences.getStringSet("countries", emptySet())
    }
    fun addCountries(countries: Set<String>){
        App.sharedPreferences.edit().putStringSet("countries", countries).apply()
    }
}