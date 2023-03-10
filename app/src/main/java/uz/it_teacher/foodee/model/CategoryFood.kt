package uz.it_teacher.foodee.model

import android.graphics.Color
import uz.it_teacher.foodee.R
enum class CategoryFood(var n:String, var photo:Int, var color: Int) {
    FREE("Fries", R.drawable.free, Color.parseColor("#FFEF92")),
    BURGERS("Burgers", R.drawable.burger, Color.parseColor("#F5CAC3")),
    ROLL("Roll", R.drawable.roll, Color.parseColor("#B6D7CF")),
    DESERT("Desert", R.drawable.desert, Color.parseColor("#BCD7B6")),
    DRINK("Drink", R.drawable.drink, Color.parseColor("#D7B6BD")),
    SANDWICH("Sandwich", R.drawable.sandwich, Color.parseColor("#D7CFB6"))
}

