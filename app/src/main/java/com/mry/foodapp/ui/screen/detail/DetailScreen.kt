package com.mry.foodapp.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.mry.foodapp.ui.FoodViewModel
import com.mry.foodapp.R
import com.mry.foodapp.ui.ViewModelFactory
import com.mry.foodapp.data.FoodRepository

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    foodId: String,
    viewModel: FoodViewModel = viewModel(factory = ViewModelFactory(FoodRepository())),
) {
    val detailFood = viewModel.getDetailFood(foodId.toInt())

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Row {
            AsyncImage(
                model = detailFood.photoUrl,
                contentDescription = detailFood.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(width = 200.dp, height = 200.dp)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = detailFood.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = detailFood.price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.description),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 16.dp),
            )
            Text(
                text = detailFood.description,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(top = 4.dp),
            )
        }
    }
}