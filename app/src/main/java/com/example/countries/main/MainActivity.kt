package com.example.countries.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.countries.main.MainViewModel
import com.example.countries.R
import com.example.countries.list.ListFragment
import com.example.countries.list.ListViewModel
import com.example.countries.list.ListViewModelFactory
import com.example.countries.login.LoginFragment

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setList()
        val fragment = LoginFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }
    private fun setList(){
        viewModel.init()
    }
    fun navigateToListFragment(){
        val fragment = ListFragment()
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}