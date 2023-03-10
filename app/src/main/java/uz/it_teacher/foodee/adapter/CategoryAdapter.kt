package uz.it_teacher.foodee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.it_teacher.foodee.databinding.ItemCategoryBinding
import uz.it_teacher.foodee.model.CategoryFood

class CategoryAdapter(val list:Array<CategoryFood>):RecyclerView.Adapter<CategoryAdapter.MyHolder>() {

    class  MyHolder(binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root){
        var category_main =binding.categoryMain
        var category_name =binding.categoryName
        var category_img =binding.categoryImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return  MyHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var c = list.get(position)
        holder.category_name.text = c.n
        holder.category_img.setImageResource(c.photo)
        holder.category_main.setCardBackgroundColor(c.color)
    }
}