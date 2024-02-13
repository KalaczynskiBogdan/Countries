package com.example.countries.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _login = MutableLiveData<String>()
    val login: LiveData<String> get() = _login

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    fun setData(login: String, password: String){
       _login.value = login
        _password.value = password
    }
    fun checkData(): Boolean{
        val loginValue = _login.value
        val passwordValue = _password.value
        return !loginValue.isNullOrEmpty() && !passwordValue.isNullOrEmpty()
    }
}