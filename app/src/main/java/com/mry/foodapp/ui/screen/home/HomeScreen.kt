package com.mry.foodapp.ui.screen.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mry.foodapp.data.FoodRepository
import com.mry.foodapp.ui.FoodViewModel
import com.mry.foodapp.ui.ViewModelFactory
import com.mry.foodapp.ui.components.FoodCardItem
import com.mry.foodapp.ui.components.SearchBar
import com.mry.foodapp.ui.theme.FoodAppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: FoodViewModel = viewModel(factory = ViewModelFactory(FoodRepository())),
    navigateToDetail: (String) -> Unit,
) {
    val foodsData by viewModel.foods.collectAsState()
    val query by viewModel.query

    Column(modifier = modifier) {
        SearchBar(
            query = query,
            onQueryChange = viewModel::search,
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            foodsData.forEach { (_, foods) ->
                items(foods, key = { it.id }) { food ->
                    FoodCardItem(
                        id = food.id,
                        name = food.name,
                        price = food.price,
                        photoUrl = food.photoUrl,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 2.dp)
                            .animateItemPlacement(
                                tween(durationMillis = 100),
                            ),
                        navigateToDetail = navigateToDetail
                    )
                }
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun HomeScreenPreview() {
    FoodAppTheme {
        HomeScreen(navigateToDetail = {})
    }
}