package fr.epita.android.mealdbapp.data

import android.content.Context
import android.provider.ContactsContract
import fr.epita.android.mealdbapp.data.network.RetrofitService
import fr.epita.android.mealdbapp.data.network.RetrofitUtility
import fr.epita.android.mealdbapp.data.repository.IMealsRepository
import fr.epita.android.mealdbapp.data.repository.MealsRepositoryImpl

class InjectorUtil {
    companion object {

        private var iMealsRepository: IMealsRepository? = null
        var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

        fun getInstance(context: Context): IMealsRepository {
            if (iMealsRepository == null) {
                synchronized(IMealsRepository::class.java) {
                    if (iMealsRepository == null) {
                        iMealsRepository = MealsRepositoryImpl(retrofitService)
                    }
                }
            }
            return iMealsRepository!!
        }
    }
}