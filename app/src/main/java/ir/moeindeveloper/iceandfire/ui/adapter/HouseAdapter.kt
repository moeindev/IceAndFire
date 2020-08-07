package ir.moeindeveloper.iceandfire.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import ir.moeindeveloper.iceandfire.databinding.ItemMultipleBinding
import ir.moeindeveloper.iceandfire.utils.intractors.HouseClickListener


class HouseAdapter(private val listener: HouseClickListener): RecyclerView.Adapter<HouseAdapter.HouseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseViewHolder {
        val binding = ItemMultipleBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return HouseViewHolder(binding)
    }

    override fun getItemCount(): Int = houses.size

    override fun onBindViewHolder(holder: HouseViewHolder, position: Int) {
        holder.bindItem(houses[position],listener)
    }

    class HouseViewHolder(private val binding: ItemMultipleBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(house: House, listener: HouseClickListener) {

            val name = house.name

            binding.itemMultipleText.text = name

            binding.root.setOnClickListener {
                listener.onHouseSelect(house)
            }
        }
    }


    private var houses: List<House> = listOf()


    fun updateHouses(houseList: List<House>) {
        houses = houseList
        notifyDataSetChanged()
    }
}