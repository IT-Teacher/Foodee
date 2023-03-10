package uz.it_teacher.foodee

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.it_teacher.foodee.adapter.CategoryAdapter
import uz.it_teacher.foodee.adapter.MenuAdapter
import uz.it_teacher.foodee.adapter.OfferFoodAdapter
import uz.it_teacher.foodee.databinding.ActivityMainBinding
import uz.it_teacher.foodee.model.CategoryFood
import uz.it_teacher.foodee.model.Food
import uz.it_teacher.foodee.model.Ingredient
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var locale: Locale
    private var currentLanguage = "en"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMenu.adapter = MenuAdapter(loadMenu())

        binding.rvCategory.adapter = CategoryAdapter(CategoryFood.values())

        val list = loadMenu()


        binding.rvOffer.adapter = OfferFoodAdapter(list,object :OfferFoodAdapter.MyOfferInterface{
            override fun onItemClick(food: Food) {
                val intent = Intent(this@MainActivity,FoodActivity::class.java)
                intent.putExtra("food", food)
                startActivity(intent)
            }

        })

        currentLanguage = intent.getStringExtra(currentLang).toString()
        val language = arrayOf("Select language","en", "ru")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, language)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.setAdapter(adapter)

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> {
                    }
                    1 -> setLocale("en")
                    2 -> setLocale("ru")

                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


    }

    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this,
                MainActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(
                this@MainActivity, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
        }
    }

    private fun loadMenu(): MutableList<Food> {
        val foods = mutableListOf<Food>()
        val ingredients = mutableListOf<Ingredient>()
        ingredients.add(Ingredient("Pepsi",R.drawable.pepsi,"$1.2"))
        ingredients.add(Ingredient("Frie",R.drawable.free1,"$0.8"))
        ingredients.add(Ingredient("Souse",R.drawable.souse,"$0.2"))
        ingredients.add(Ingredient("Burger",R.drawable.burger,"$1.2"))
        foods.add(
            Food(
                "Chikaros Chiken",
                "For orders over \$52",
                R.drawable.freebox,
                Color.parseColor("#84A59D"),
                ingredients
            )
        )
        foods.add(
            Food(
                "Free Donut!",
                "For orders over \$20",
                R.drawable.donut,
                Color.parseColor("#F6BD60"),
                ingredients
            )
        )
        foods.add(
            Food(
                "Mini combobox",
                "For orders over \$32",
                R.drawable.comobox,
                Color.parseColor("#58D1E1"),
                ingredients
            )
        )
        foods.add(
            Food(
                "Complate Box",
                "For orders over \$64",
                R.drawable.complatebox,
                Color.parseColor("#81ED68"),
                ingredients
            )
        )
        foods.add(
            Food(
                "My cafe",
                "For orders over \$6",
                R.drawable.mycafe,
                Color.parseColor("#E772EF"),
                ingredients
            )
        )
        return foods
    }
}