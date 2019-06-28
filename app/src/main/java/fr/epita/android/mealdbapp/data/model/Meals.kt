package fr.epita.android.mealdbapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meals {
    @SerializedName("meals")
    @Expose
    var meals: List<Meal>? = null
}