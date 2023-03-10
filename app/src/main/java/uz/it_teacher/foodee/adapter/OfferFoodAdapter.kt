package uz.it_teacher.foodee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.it_teacher.foodee.databinding.ItemOfferBinding
import uz.it_teacher.foodee.model.Food

class OfferFoodAdapter(val list:MutableList<Food>, var myOfferInterface: MyOfferInterface): RecyclerView.Adapter<OfferFoodAdapter.MyHolder>() {

    class MyHolder(binding: ItemOfferBinding) :RecyclerView.ViewHolder(binding.root){
        var offer_img = binding.offerImg
        var offer_name = binding.offerName
        var card = binding.cardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(ItemOfferBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val o = list[position]
        holder.offer_name.text = o.name
        holder.offer_img.setImageResource(o.photo)

        holder.card.setOnClickListener {
            myOfferInterface.onItemClick(o)
        }
    }
    interface MyOfferInterface{
        fun onItemClick(food: Food)
    }
}