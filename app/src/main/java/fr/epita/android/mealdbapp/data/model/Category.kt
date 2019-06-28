package fr.epita.android.mealdbapp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {
    @SerializedName("idCategory")
    @Expose
    private var idCategory: String? = null
    @SerializedName("strCategory")
    @Expose
    private var strCategory: String? = null
    @SerializedName("strCategoryThumb")
    @Expose
    private var strCategoryThumb: String? = null
    @SerializedName("strCategoryDescription")
    @Expose
    private var strCategoryDescription: String? = null

    fun getIdCategory(): String? {
        return idCategory
    }

    fun setIdCategory(idCategory: String) {
        this.idCategory = idCategory
    }

    fun getStrCategory(): String? {
        return strCategory
    }

    fun setStrCategory(strCategory: String) {
        this.strCategory = strCategory
    }

    fun getStrCategoryThumb(): String? {
        return strCategoryThumb
    }

    fun setStrCategoryThumb(strCategoryThumb: String) {
        this.strCategoryThumb = strCategoryThumb
    }

    fun getStrCategoryDescription(): String? {
        return strCategoryDescription
    }

    fun setStrCategoryDescription(strCategoryDescription: String) {
        this.strCategoryDescription = strCategoryDescription
    }

}