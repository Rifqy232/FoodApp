package com.mry.foodapp.ui.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mry.foodapp.ui.theme.FoodAppTheme

@Composable
fun AboutScreen(
    photoUrl: String,
    name: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .size(200.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = email,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(device = Devices.PIXEL_4, showBackground = true)
@Composable
fun AboutScreenPreview() {
    FoodAppTheme {
        AboutScreen(
            "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:a0522d457f3da6ff36fba762a6ebd23c20220714204146.png",
            "Muhammad Rifqy Yudhiestra Rachman",
            "yudhiestrarifqy@gmail.com"
        )
    }
}