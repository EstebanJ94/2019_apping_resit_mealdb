package fr.epita.android.mealdbapp.presentation.random

import android.app.Application
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.presentation.home.Home
import fr.epita.android.mealdbapp.viewmodel.RandomMealViewModel

class RandomMealAdapter(private val randomMealViewModel: RandomMealViewModel): RecyclerView.Adapter<RandomMealAdapter.MealListViewHolder>() {

    class MealListViewHolder(var view: View): RecyclerView.ViewHolder(view),View.OnClickListener {
        override fun onClick(v: View?) {
            val randomMealFragment = RandomMealsFragment.newInstance()
           /* val transaction = supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_layout_home_screen, randomMealFragment)
            transaction?.commit()*/
        }

        var mealName: TextView
        var mealCategory: TextView
        var mealArea: TextView
        var mealThumb: ImageView

        var ingredient1: TextView
        var ingredient2: TextView
        var ingredient3: TextView
        var ingredient4: TextView
        var ingredient5: TextView
        var ingredient6: TextView
        var measure1: TextView
        var measure2: TextView
        var measure3: TextView
        var measure4: TextView
        var measure5: TextView
        var measure6: TextView

        var instructions: TextView
        var sourceUrl: TextView
        var shuffleFAB: FloatingActionButton

        init {
            mealName = view.findViewById(R.id.textViewRandomMealName)
            mealCategory = view.findViewById(R.id.textViewRandomCategory)
            mealArea = view.findViewById(R.id.textViewRandomMealArea)
            mealThumb = view.findViewById(R.id.imageViewRandomMealThumb)
            ingredient1 = view.findViewById(R.id.textViewIngredient1)
            ingredient2 = view.findViewById(R.id.textViewIngredient2)
            ingredient3 = view.findViewById(R.id.textViewIngredient3)
            ingredient4 = view.findViewById(R.id.textViewIngredient4)
            ingredient5 = view.findViewById(R.id.textViewIngredient5)
            ingredient6 = view.findViewById(R.id.textViewIngredient6)
            measure1 = view.findViewById(R.id.textViewMeasure1)
            measure2 = view.findViewById(R.id.textViewMeasure2)
            measure3 = view.findViewById(R.id.textViewMeasure3)
            measure4 = view.findViewById(R.id.textViewMeasure4)
            measure5 = view.findViewById(R.id.textViewMeasure5)
            measure6 = view.findViewById(R.id.textViewMeasure6)
            instructions = view.findViewById(R.id.textViewIns)
            sourceUrl = view.findViewById(R.id.textViewRandomSourceText)
            shuffleFAB = view.findViewById(R.id.floatingActionButtonShuffle)
            shuffleFAB.setOnClickListener(this)
        }
    }

    override fun onBindViewHolder(holder: MealListViewHolder, position: Int) {
        val meal: Meal = randomMealViewModel.getMealAt(position)!!
        Picasso.get().load(meal.getStrMealThumb()).into(holder.mealThumb)
        holder.mealName.text = meal.getStrMeal()
        holder.mealCategory.text = meal.getStrCategory()
        holder.mealArea.text = meal.getStrArea()
        holder.ingredient1.text = meal.getStrIngredient1()
        holder.ingredient2.text = meal.getStrIngredient2()
        holder.ingredient3.text = meal.getStrIngredient3()
        holder.ingredient4.text = meal.getStrIngredient4()
        holder.ingredient5.text = meal.getStrIngredient5()
        holder.ingredient6.text = meal.getStrIngredient6()
        holder.measure1.text = meal.getStrMeasure1()
        holder.measure2.text = meal.getStrMeasure2()
        holder.measure3.text = meal.getStrMeasure3()
        holder.measure4.text = meal.getStrMeasure4()
        holder.measure5.text = meal.getStrMeasure5()
        holder.measure6.text = meal.getStrMeasure6()
        holder.instructions.text = meal.getStrInstructions()
        holder.sourceUrl.text = meal.getStrSource()
        holder.view.tag = position
    }

    override fun getItemCount(): Int {
        return randomMealViewModel.getMealSize()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListViewHolder {
        val listView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_random_meal,parent,false)
        return MealListViewHolder(listView)
    }
}