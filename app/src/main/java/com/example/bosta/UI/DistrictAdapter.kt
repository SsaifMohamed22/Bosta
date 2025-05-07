package com.example.bosta.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bosta.MODELS.District
import com.example.bosta.databinding.ItemDistrictBinding

class DistrictAdapter(private val districts: List<District>) : RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder>() {

    inner class DistrictViewHolder(val binding: ItemDistrictBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DistrictViewHolder {
        val binding = ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DistrictViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DistrictViewHolder, position: Int) {
        val district = districts[position]
        holder.binding.districtNameTextView.text = "${district.districtName} - ${district.districtOtherName}"

        holder.binding.coverageBadge.visibility = if (district.coverage != "BOSTA") {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun getItemCount(): Int = districts.size
}