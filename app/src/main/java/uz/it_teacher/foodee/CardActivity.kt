package uz.it_teacher.foodee

import android.annotation.SuppressLint
import android.media.session.MediaSession.Token
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.it_teacher.foodee.adapter.CardAdapter
import uz.it_teacher.foodee.databinding.ActivityCard2Binding
import uz.it_teacher.foodee.model.Food
import java.lang.reflect.Type

class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCard2Binding
    private lateinit var foods: MutableList<Food>

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCard2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val food: Food = intent.getSerializableExtra("food") as Food

        val file = getSharedPreferences("food", MODE_PRIVATE)
        val edit = file.edit()
        val type: Type = object : TypeToken<List<Food>>() {}.type
        val gson = Gson()
        var str = file.getString("foodList", "")

        if (str == "") {
            foods = mutableListOf()

        } else{
            foods = gson.fromJson(str, type)
        }
        foods.add(food)
        str = gson.toJson(foods)
        edit.putString("foodList", str).apply()



        binding.rvCard.adapter = CardAdapter(foods)


    }
}