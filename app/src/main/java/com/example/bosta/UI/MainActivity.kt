package com.example.bosta.UI

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bosta.API.RetrofitClient
import com.example.bosta.R
import com.example.bosta.REPOSITORY.CityRepository
import com.example.bosta.VIEWMODEL.CityViewModel
import com.example.bosta.VIEWMODEL.CityViewModelFactory
import com.example.bosta.databinding.ActivityMainBinding
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CityViewModel
    private lateinit var adapter: CityAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.searchEditText)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val repository = CityRepository(RetrofitClient.apiService)
        viewModel = ViewModelProvider(this, CityViewModelFactory(repository))[CityViewModel::class.java]

        binding.cityRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.cities.observe(this) {
            adapter = CityAdapter(it)
            binding.cityRecyclerView.adapter = adapter
        }

        binding.searchEditText.addTextChangedListener {
            viewModel.filterCities(it.toString())
        }

        viewModel.loadCities()
    }
}