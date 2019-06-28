package fr.epita.android.mealdbapp.presentation.category

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.data.model.Category
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.viewmodel.MealCategoriesViewModel

class MealCategoryListAdapter(private val mealCategoryViewModel: MealCategoriesViewModel) : RecyclerView.Adapter<MealCategoryListAdapter.MealCategoryListViewHolder>(){

    class MealCategoryListViewHolder(var view: View): RecyclerView.ViewHolder(view) {

        var categoryName: TextView
        var mealThumb: ImageView
        var categoryDescription: TextView

        init {
            categoryName = view.findViewById(R.id.textViewCategoryName)
            mealThumb = view.findViewById(R.id.imageViewCategoryThumb)
            categoryDescription = view.findViewById(R.id.textViewCategoryDescription)
        }
    }
    override fun onBindViewHolder(holderCategory: MealCategoryListViewHolder, position: Int) {
        val mealCategory: Category = mealCategoryViewModel.getMealCategoryAt(position)!!
        holderCategory.categoryName.text = mealCategory.getStrCategory()
        Picasso.get().load(mealCategory.getStrCategoryThumb()).into(holderCategory.mealThumb)
        holderCategory.categoryDescription.text = mealCategory.getStrCategoryDescription()
        holderCategory.view.tag = position
    }

    override fun getItemCount(): Int {
        return mealCategoryViewModel.getCategorySize()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealCategoryListViewHolder {
        val listView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_meal_categories,parent,false)
        return MealCategoryListViewHolder(listView)
    }
}