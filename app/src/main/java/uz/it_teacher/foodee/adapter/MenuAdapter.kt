package uz.it_teacher.foodee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.it_teacher.foodee.R
import uz.it_teacher.foodee.databinding.ItemMenuBinding
import uz.it_teacher.foodee.model.Food

class MenuAdapter(val foodList:MutableList<Food>):RecyclerView.Adapter<MenuAdapter.MyHolder>() {

    class MyHolder(binding: ItemMenuBinding) :RecyclerView.ViewHolder(binding.root){
        var menu_card = binding.menuCard
        var menu_name = binding.menuName
        var menu_price = binding.menuPrice
        var menu_img = binding.menuImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(ItemMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var food = foodList.get(position)
        holder.menu_card.setCardBackgroundColor(food.colorBg)
        holder.menu_name.text = food.name
        holder.menu_price.text = food.price
        holder.menu_img.setImageResource(food.photo)

    }
}