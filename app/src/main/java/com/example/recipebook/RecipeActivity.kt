package com.example.recipebook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recipebook.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intentFromComingAdapter = intent
        val chosenRecipe = intentFromComingAdapter.getSerializableExtra("chosenRecipe") as Recipes

        binding.imageFoodView.setImageResource(chosenRecipe.image)
        binding.textTitleView.text = chosenRecipe.name
        binding.textIngredientsView.text = chosenRecipe.ingredients
        binding.textMethodView.text = chosenRecipe.method
    }
}