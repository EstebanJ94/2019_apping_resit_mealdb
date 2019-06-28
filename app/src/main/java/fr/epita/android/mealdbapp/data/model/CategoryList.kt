package fr.epita.android.mealdbapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryList {
    @SerializedName("categories")
    @Expose
    private var categories: List<Category>? = null

    fun getCategories(): List<Category>? {
        return categories
    }

    fun setCategories(categories: List<Category>) {
        this.categories = categories
    }
}