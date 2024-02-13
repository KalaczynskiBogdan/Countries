package com.example.countries.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countries.R
import com.example.countries.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val viewModel: ListViewModel by lazy {
         ViewModelProvider(this, ListViewModelFactory())[ListViewModel::class.java]
    }
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.countries.observe(viewLifecycleOwner, Observer {
            Log.e("Errrorchik", it.toString())
            if (!it.isNullOrEmpty()){
                val adapter = ArrayAdapter(requireContext(), R.layout.country_item, it.toList())
                binding.listView.adapter = adapter
            }
        })
    }
}