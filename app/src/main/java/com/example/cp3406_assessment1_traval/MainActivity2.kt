package com.example.cp3406_assessment1_traval
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person

import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_assessment1_travalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TravelDisplay(modifier = Modifier.padding(innerPadding))
                    BottomNavigationTravelUI()
                }
            }
        }
    }
}
@Composable
fun TravelDisplay(modifier: Modifier = Modifier) {
    val items = listOf("⚡\uFE0F\$8:00am Singapore airline\n     Flight number: CA123", "⚡\uFE0F\\12:00 check in \n     Location: Marina Bay Sands Hotel", "17:00pm ABC swimming poor\n     Location:Marina Square", "wwwwww\n" +
            "     Location:Marina Square","tttttt\n",
            "     Location:Marina Square")
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.singapore),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        )
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .heightIn(min = 300.dp),
            elevation = CardDefaults.cardElevation(4.dp)


        ) {
            Column(modifier = Modifier.padding(13.dp)) {
                Text(text = "Today's itinerary: Singapore", style = MaterialTheme.typography.headlineLarge)

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "07/02/2025, Weather:25-31c Cloudy...",
                    maxLines = 3
                )

Row(modifier = Modifier.fillMaxWidth()){
    TextButton(onClick = {  }) {
        Text(text = "Read More")
    }
    TextButton(onClick = {  }) {
        Text(text = "ChatGPT-AI-Assisted Planning", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LazyColumn(modifier = Modifier
                        .height(400.dp)
                        .clipToBounds()) {
            items(items.size) { index ->
                Column (
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

                        .shadow(10.dp, RoundedCornerShape(10.dp))
                    .background(Color.White ,shape = RoundedCornerShape(12.dp))
                        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, // 水平居中
                    verticalArrangement = Arrangement.Center){

                    Text(
                    text = items[index],
                    fontSize = 20.sp,
                        color = Color.Black

                )
                Row(){
                    Button(
                        onClick = {  },
                        modifier = Modifier.padding(start = 10.dp),

                        ) {
                        Text(text = "Map")
                    }
                    Button(
                        onClick = {  },
                        modifier = Modifier.padding(start = 10.dp),

                        ) {
                        Text(text = "EDIT")
                    }
                }

                    }


            }
        }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationTravelUI() {
    var selectedIndex by remember { mutableStateOf(0) }
    val navItems = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Travel", Icons.Default.DateRange),
        NavItem("Booking", Icons.Default.Check),
        NavItem("Budget", Icons.Default.Person),
        NavItem("Notification", Icons.Default.Notifications)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                        label = { Text(text = item.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        TravelDisplay(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true, name = "TravelDisplay")
@Composable
fun TravalShow(){
    CP3406_assessment1_travalTheme {
        TravelDisplay()
        BottomNavigationTravelUI()
    }
}








