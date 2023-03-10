package uz.it_teacher.foodee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.it_teacher.foodee.R
import uz.it_teacher.foodee.model.Ingredient

class IngredientAdapter(var mutableList: MutableList<Ingredient>):RecyclerView.Adapter<IngredientAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val price = itemView.findViewById<TextView>(R.id.price)
        val image = itemView.findViewById<ImageView>(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val ingredient = mutableList.get(position)
        holder.name.text = ingredient.name
        holder.price.text = ingredient.price
        holder.image.setImageResource(ingredient.img)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }
}