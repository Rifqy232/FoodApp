package com.mry.foodapp.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mry.foodapp.data.FoodRepository
import com.mry.foodapp.model.Food
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FoodViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _foods = MutableStateFlow(
        repository.getFoods()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val foods: StateFlow<Map<Char, List<Food>>> get() = _foods

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _foods.value = repository.searchedFoods(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

    fun getDetailFood(id: Int) = repository.getDetailFood(id)
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: FoodRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            return FoodViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model class: " + modelClass.name)
    }
}