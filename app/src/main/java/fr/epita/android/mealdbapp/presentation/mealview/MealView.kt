package fr.epita.android.mealdbapp.presentation.mealview

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.viewmodel.MealViewViewModel

class MealView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_view)
        val mealId = intent.getStringExtra("mealId")
        val viewModel = MealViewViewModel(application)
        val mealViewAdapter = MealViewAdapter(viewModel)
        viewModel.getMealById(mealId)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mealViewAdapter
        viewModel.mealsResponse.observe(this, Observer<List<Meal>> {
            it?.let { mealViewAdapter.notifyDataSetChanged() }
        })

    }
}
