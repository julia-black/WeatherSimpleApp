package com.juliablack.weathersimpleapp.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.juliablack.domain.model.City
import com.juliablack.weathersimpleapp.databinding.ViewCityBinding

class CityAdapter(
    private val items: List<City>
) : Adapter<CityVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CityVH(
        ViewCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CityVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

class CityVH(private val itemViewBinding: ViewCityBinding) : ViewHolder(itemViewBinding.root) {
    fun bind(city: City) {
        itemViewBinding.cityName.text = city.name
    }
}