package com.example.countries.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListViewModel::class.java))
        {
            return ListViewModel() as T
        }
        throw IllegalArgumentException("unknown viewModel")
    }
}