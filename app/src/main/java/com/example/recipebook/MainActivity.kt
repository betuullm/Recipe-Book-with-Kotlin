package com.example.recipebook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipebook.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recipeList: ArrayList<Recipes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loremipsum = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
        val ingredients = "Spaghetti, Pancetta or Guanciale (Italian cured meat), Eggs, Pecorino Romano cheese, Parmesan cheese, Garlic (optional), Black pepper, Salt, Olive oil"

        val recipe_1= Recipes("Soup","Tomato Soup",ingredients, loremipsum, R.drawable.s1)
        val recipe_2= Recipes("Soup","Pea Soup",ingredients,loremipsum, R.drawable.s2)
        val recipe_3= Recipes("Soup","Yogurt Soup",ingredients,loremipsum, R.drawable.s3)
        val recipe_4= Recipes("Cake","Asure",ingredients,loremipsum, R.drawable.k1)
        val recipe_5= Recipes("Cake","Magnolia",ingredients,loremipsum, R.drawable.k2)
        val recipe_6= Recipes("Cake","Cold Baklava",ingredients,loremipsum, R.drawable.k3)
        val recipe_7= Recipes("Meat","Beef",ingredients,loremipsum, R.drawable.m1)
        val recipe_8= Recipes("Meat","Chicken",ingredients,loremipsum, R.drawable.m2)
        val recipe_9= Recipes("Meat","Fish",ingredients,loremipsum, R.drawable.m3)
        val recipe_10= Recipes("Pasta","Pasta with Pesto Sauce",ingredients,loremipsum, R.drawable.p1)
        val recipe_11= Recipes("Pasta","Pasta with Tomato Sauce",ingredients,loremipsum, R.drawable.p2)
        val recipe_12= Recipes("Pasta","Pasta with Beetroot Sauce",ingredients,loremipsum, R.drawable.p3)

        recipeList = arrayListOf(recipe_1,recipe_2,recipe_3,recipe_4,recipe_5,recipe_6,recipe_7,recipe_8,recipe_9,recipe_10,recipe_11,recipe_12)

        val adapter = RecipeAdapter(recipeList)
        binding.recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.recipeRecyclerView.adapter = adapter

    }
}