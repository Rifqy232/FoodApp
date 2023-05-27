package com.mry.foodapp.data

import com.mry.foodapp.model.Food
import com.mry.foodapp.model.FoodData

class FoodRepository {
    fun getFoods(): List<Food> {
        return FoodData.foods
    }

    fun searchedFoods(query: String): List<Food> {
        return FoodData.foods.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getDetailFood(index: Int): Food {
        return FoodData.foods[index - 1]
    }
}