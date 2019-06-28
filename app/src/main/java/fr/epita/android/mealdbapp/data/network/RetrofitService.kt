package fr.epita.android.mealdbapp.data.network

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import fr.epita.android.mealdbapp.data.model.Category
import fr.epita.android.mealdbapp.data.model.CategoryList
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.data.model.Meals

interface RetrofitService {
    @GET("latest.php/")
    fun getLatestMeals(): Call<Meals>

    @GET("categories.php")
    fun getMealCategories(): Call<CategoryList>

    @GET("random.php")
    fun getRandomMeal(): Call<Meals>

    @GET("https://www.themealdb.com/api/json/v1/1/lookup.php?i=")
    fun getMealById(@Query("i")id:String): Call<Meals>
}