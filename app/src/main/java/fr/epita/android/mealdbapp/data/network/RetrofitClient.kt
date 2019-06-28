package fr.epita.android.mealdbapp.data.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class RetrofitClient {

    companion object {

        var client: Retrofit? = null
        fun getClient(baseURL: String): Retrofit {
            if (client == null) {
                client = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return client!!
        }
    }

}