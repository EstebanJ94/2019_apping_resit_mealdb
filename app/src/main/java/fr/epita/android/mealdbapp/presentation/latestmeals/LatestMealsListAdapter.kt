package za.co.pabimoloi.parmesan.presentation.latestmeals

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import za.co.pabimoloi.parmesan.presentation.mealview.MealView
import za.co.pabimoloi.parmesan.R
import za.co.pabimoloi.parmesan.data.model.Meal
import za.co.pabimoloi.parmesan.viewmodel.LatestMealsViewModel

class LatestMealsListAdapter(private val viewModel: LatestMealsViewModel) : RecyclerView.Adapter<LatestMealsListAdapter.MealListViewHolder>() {

    class MealListViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var mealName: TextView
        var mealCategory: TextView
        var mealArea: TextView
        var mealThumb: ImageView

        init {
            mealName = view.findViewById(R.id.textViewLatestMealName)
            mealCategory = view.findViewById(R.id.textViewLatestMealCategory)
            mealArea = view.findViewById(R.id.textViewLatestMealArea)
            mealThumb = view.findViewById(R.id.imageViewLatestMealsThumb)

        }
    }

    override fun onBindViewHolder(holder: MealListViewHolder, position: Int) {
        val meal: Meal = viewModel.getMealAt(position)!!
        holder.mealName.text = meal.getStrMeal()
        holder.mealCategory.text = meal.getStrCategory()
        holder.mealArea.text = meal.getStrArea()
        Picasso.get().load(meal.getStrMealThumb()).into(holder.mealThumb)
        holder.view.tag = position
        holder.view.setOnClickListener { view ->
            val intent = Intent(view.context, MealView::class.java)
            intent.putExtra("mealId",meal.getIdMeal())
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.getMealSize()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListViewHolder {
        val listView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_latest_meals,parent,false)
        return MealListViewHolder(listView)
    }
}