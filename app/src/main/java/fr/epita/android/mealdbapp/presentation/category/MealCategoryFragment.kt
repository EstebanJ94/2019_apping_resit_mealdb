package fr.epita.android.mealdbapp.presentation.category

import android.app.Application
import androidx.lifecycle.Observer
import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.data.model.Category
import fr.epita.android.mealdbapp.viewmodel.MealCategoriesViewModel

class MealCategoryFragment: Fragment() {

    companion object {
        fun newInstance(): MealCategoryFragment {
            return MealCategoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = MealCategoriesViewModel(Application())
        val mealCategoryListAdapter = MealCategoryListAdapter(viewModel)
        viewModel.getMealCategories()
        val view:View = inflater.inflate(R.layout.fragment_meal_category, container, false)
        val recyclerView =view.findViewById<RecyclerView>(R.id.categoryRecycler)
        recyclerView.layoutManager = LinearLayoutManager(activity,0,false)
                //GridLayoutManager(requireContext(),2)
        recyclerView.adapter = mealCategoryListAdapter
        viewModel.categoryResponse.observe(this, Observer<List<Category>> {
            it?.let { mealCategoryListAdapter.notifyDataSetChanged() }
        })
        return view
    }
}