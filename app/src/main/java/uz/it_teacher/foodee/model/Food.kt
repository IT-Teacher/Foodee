package uz.it_teacher.foodee.model

data class Food(var name:String,
                var price:String,
                var photo:Int,
                var colorBg:Int,
                var ingredients: MutableList<Ingredient>
                ):java.io.Serializable