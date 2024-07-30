package com.example.recipebook

import java.io.Serializable

class Recipes (val species: String, val name: String, val ingredients: String, val method:String,val image:Int ): Serializable {
}