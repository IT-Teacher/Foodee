package uz.it_teacher.foodee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.it_teacher.foodee.databinding.ItemCardBinding
import uz.it_teacher.foodee.model.Food

class CardAdapter(var list:MutableList<Food>):RecyclerView.Adapter<CardAdapter.MyCardHolder>() {

    class MyCardHolder(binding: ItemCardBinding) :RecyclerView.ViewHolder(binding.root){
        val name = binding.offerName
        val img = binding.offerImg
        val  delete = binding.delete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCardHolder {
        return MyCardHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyCardHolder, position: Int) {
        val food = list[position]
        holder.name.text = food.name
        holder.img.setImageResource(food.photo)
        holder.delete.setOnClickListener {
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}