package com.example.countries.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.countries.main.MainActivity
import com.example.countries.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var login: String = ""
    private var password: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(
            this,
            LoginViewModelFactory()
        )[LoginViewModel::class.java]

        binding.btnSave.setOnClickListener {
            login = binding.etLogin.text.toString()
            password = binding.etPassword.text.toString()
            loginViewModel.setData(login, password)

            val valid = loginViewModel.checkData()
            if (valid) {
                (activity as MainActivity).navigateToListFragment()
            } else {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
