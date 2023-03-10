package uz.it_teacher.foodee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.it_teacher.foodee.adapter.IngredientAdapter
import uz.it_teacher.foodee.databinding.ActivityFoodBinding
import uz.it_teacher.foodee.model.Food

class FoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.close.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val food :Food = intent.getSerializableExtra("food") as Food

        binding.maintitle.text = food.name
        binding.selectedItemImg.setImageResource(food.photo)

        binding.mahrecycler.adapter = IngredientAdapter(food.ingredients)

        binding.addcard.setOnClickListener {
            val intent = Intent(this, CardActivity::class.java)
            intent.putExtra("food",food)
            startActivity(intent)
            finish()
        }

    }
}