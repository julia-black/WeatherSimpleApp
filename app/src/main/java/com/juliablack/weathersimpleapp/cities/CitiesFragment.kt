package com.juliablack.weathersimpleapp.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliablack.weathersimpleapp.databinding.FragmentCitiesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesFragment : Fragment() {

    private val viewModel: CitiesViewModel by viewModels()

    private var _binding: FragmentCitiesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateQuery(query: String) {
        if (query.length > 2) {
            viewModel.getCities(query)
        }
    }

    private fun addObservers() {
        viewModel.liveCities.observe(requireActivity()) {
            binding.citiesList.adapter = CityAdapter(it)
            binding.citiesList.layoutManager = LinearLayoutManager(context)
        }
    }
}