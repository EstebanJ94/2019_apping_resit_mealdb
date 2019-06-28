package fr.epita.android.mealdbapp.presentation.latestmeals

import android.app.Application
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.data.model.Meal
import fr.epita.android.mealdbapp.viewmodel.LatestMealsViewModel

class LatestMealsFragment: Fragment() {
    companion object {
        fun newInstance(): LatestMealsFragment {
            return LatestMealsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val viewModel = LatestMealsViewModel(Application())
        val latestMealsListAdapter = LatestMealsListAdapter(viewModel)
        viewModel.getMeals()
        val view:View = inflater.inflate(R.layout.fragment_latest_meals, container, false)
        val recyclerView =view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,1)
                // LinearLayoutManager(activity)
        recyclerView.adapter = latestMealsListAdapter
        viewModel.mealsResponse.observe(this, Observer<List<Meal>> {
            it?.let { latestMealsListAdapter.notifyDataSetChanged() }
        })

        return view
    }

}