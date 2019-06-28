package fr.epita.android.mealdbapp.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import fr.epita.android.mealdbapp.data.InjectorUtil
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.data.repository.IMealsRepository

class RandomMealViewModel (private val application: Application): ViewModel() {

    private lateinit var iMealsRepository: IMealsRepository
    var mealsResponse: MutableLiveData<List<Meal>> = MutableLiveData()
    var apiError = MutableLiveData<Throwable>()

    fun getMeals() {
        iMealsRepository = InjectorUtil.getInstance(application)
        iMealsRepository.getRandomMeals(
            {
                mealsResponse.value = it
            },
            {
                apiError.value = it

            })
    }
    fun getMealSize(): Int {
        mealsResponse.value?.let {
            return it.size
        }
        return 0
    }
    fun getMealAt(position: Int): Meal? {
        return if (position < getMealSize()) {
            mealsResponse.value?.get(position)
        } else {
            null
        }
    }
}