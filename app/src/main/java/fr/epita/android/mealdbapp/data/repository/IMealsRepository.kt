package fr.epita.android.mealdbapp.data.repository

import androidx.lifecycle.LiveData
import retrofit2.Call
import fr.epita.android.mealdbapp.data.model.Category
import fr.epita.android.mealdbapp.data.model.CategoryList
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.data.model.Meals

interface IMealsRepository {

    fun getMealById(id: String,successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getLatestMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getMealCategories(successHandler: (List<Category>?) -> Unit, failureHandler: (Throwable?) -> Unit)
    fun getRandomMeals(successHandler: (List<Meal>?) -> Unit, failureHandler: (Throwable?) -> Unit)
}