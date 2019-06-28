package fr.epita.android.mealdbapp.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import fr.epita.android.mealdbapp.data.InjectorUtil
import fr.epita.android.mealdbapp.data.model.Category
import fr.epita.android.mealdbapp.data.repository.IMealsRepository

class MealCategoriesViewModel(private val application: Application): ViewModel()  {

    lateinit var iMealsRepository: IMealsRepository
    var categoryResponse: MutableLiveData<List<Category>> = MutableLiveData()
    var apiError = MutableLiveData<Throwable>()

    fun getMealCategories(){
        iMealsRepository = InjectorUtil.getInstance(application)
        iMealsRepository.getMealCategories(
            {
                categoryResponse.value = it
            },
            {
                apiError.value = it
            }
        )
    }
    fun getCategorySize(): Int {
        categoryResponse.value?.let {
            return it.size
        }
        return 0
    }
    fun getMealCategoryAt(position: Int): Category? {
        return if (position < getCategorySize()) {
            categoryResponse.value?.get(position)
        } else {
            null
        }
    }
}