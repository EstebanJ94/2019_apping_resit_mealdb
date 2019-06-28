package fr.epita.android.mealdbapp.presentation.random

import android.app.Application
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.viewmodel.RandomMealViewModel

class RandomMealsFragment: Fragment() {
    companion object {
        fun newInstance(): RandomMealsFragment {
            return RandomMealsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val viewModel = RandomMealViewModel(Application())
        val randomMealAdapter = RandomMealAdapter(viewModel)
        viewModel.getMeals()
        val view: View = inflater.inflate(R.layout.fragment_random_meal, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRandom)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = randomMealAdapter
        viewModel.mealsResponse.observe(this, Observer<List<Meal>> {
            it?.let { randomMealAdapter.notifyDataSetChanged() }
        })
        return view
    }
}