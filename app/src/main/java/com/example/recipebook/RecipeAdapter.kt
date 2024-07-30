package com.example.recipebook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipebook.databinding.RecyclerRowBinding

class RecipeAdapter(val recipeList: ArrayList<Recipes> ): RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder ( val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.textSpeciesView.text = recipeList[position].name

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,RecipeActivity::class.java)
            intent.putExtra("chosenRecipe",recipeList[position])
            holder.itemView.context.startActivity(intent)
        }
    }

}