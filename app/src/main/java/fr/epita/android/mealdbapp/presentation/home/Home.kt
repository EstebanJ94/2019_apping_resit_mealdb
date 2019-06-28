package fr.epita.android.mealdbapp.presentation.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import fr.epita.android.mealdbapp.R
import fr.epita.android.mealdbapp.presentation.random.RandomMealsFragment
import fr.epita.android.mealdbapp.presentation.category.MealCategoryFragment
import fr.epita.android.mealdbapp.presentation.latestmeals.LatestMealsFragment

class Home : AppCompatActivity(){

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_meal -> {
                val latestMealsFragment = LatestMealsFragment.newInstance()
                openFragment(latestMealsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_meal_categories -> {
                val mealCategoryFragment = MealCategoryFragment.newInstance()
                openFragment(mealCategoryFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_meal_ingredient -> {
                val randomMealFragment = RandomMealsFragment.newInstance()
                openFragment(randomMealFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout_home_screen, fragment)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setSelectedItemId(R.id.navigation_meal)
    }
}
