package com.example.bosta.UI

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bosta.MODELS.City
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bosta.databinding.ItemCityBinding

import com.example.bosta.UI.DistrictAdapter

class CityAdapter(private val cities: List<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    inner class CityViewHolder(val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.binding.cityNameTextView.text = city.cityName

        holder.binding.cityNameTextView.setOnClickListener {
            city.isExpanded = !city.isExpanded
            notifyItemChanged(position)
        }

        holder.binding.districtRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DistrictAdapter(city.districts)
            visibility = if (city.isExpanded) View.VISIBLE else View.GONE
        }
    }

    override fun getItemCount(): Int = cities.size
}
