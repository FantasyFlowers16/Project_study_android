package com.example.project_study.data.objects

import com.google.gson.annotations.SerializedName
data class Recipes (
    @SerializedName("recipes")
    val recipes: List<RecipeItem>

)
data class Recipe(
        @SerializedName("recipe")
        val recipe: RecipeItem
)

data class RecipeItem(

        @SerializedName("uuid")
        val uuid: String,

        @SerializedName("name")
        val name: String,

        @SerializedName("images")
        val images: List<String>,

        @SerializedName("description")
        val description: String,

        @SerializedName("instructions")
        val instructions: String,

        @SerializedName("difficulty")
        val difficulty: Int
)  {

}
