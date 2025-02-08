package com.example.cp3406_assessment1_traval

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme
import androidx.activity.ComponentActivity
class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_assessment1_travalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DashboardView(modifier = Modifier.padding(innerPadding))
                }
            }
    }}
}
@Composable
fun ImageCard(category: CategoryItem) {
    Column(
        modifier = Modifier.width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(18.dp)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Image(
                painter = painterResource(category.iconRes),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = category.label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}
data class CategoryItem(val iconRes: Int, val label: String)
@Composable
fun CategoryIconsRow(){
    val categories = listOf( CategoryItem(R.drawable.traval, "Flights"),
    CategoryItem(R.drawable.budget, "Finance"),
    CategoryItem(R.drawable.smart, "Bell"),
    CategoryItem(R.drawable.setting, "Settings"))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        items(categories) { category ->
            ImageCard(category)
        }
    }
}
@Composable
fun CityRecommend(){
    val Cities = listOf( CategoryItem(R.drawable.hongkong, "HongKong"),
        CategoryItem(R.drawable.sydney, "Sydney"),
        CategoryItem(R.drawable.singaporecity, "Singapore"),
        CategoryItem(R.drawable.newyork, "NewYork"))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(Cities) { city ->
            CityCard(city)
        }
    }
}
@Composable
fun CityCard(city: CategoryItem) {
    Column(
        modifier = Modifier.width(180.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(180.dp)
                .clip(RoundedCornerShape(20.dp)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Image(
                painter = painterResource(city.iconRes),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = city.label,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun DashboardView(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.recommendation),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Card(
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
            colors = CardDefaults.cardColors(containerColor = Color((0xFFF0F8FF))), // 正确设置背景色
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .heightIn(min = 650.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hi,Mr.Wu!!",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                CategoryIconsRow()
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Recommendation：",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                CityRecommend()
            }

        }
    }

}

@Preview(showBackground = true, name = "Dashboard")
@Composable
fun DashboardShow() {
    DashboardView()
}

