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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme

class MainActivity4map : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_assessment1_travalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapView(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun MapView(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()){
        SearchBar()

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = "Your location",
                onValueChange = {},
                modifier = Modifier.weight(0.5f),
                textStyle = TextStyle(fontSize = 16.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Red
                )
            )


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = "Your Destination: Marina",
                onValueChange = {},
                modifier = Modifier.weight(0.5f),
                textStyle = TextStyle(fontSize = 16.sp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Red
                ))


        }
        TransportationSelect()

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Card(colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .heightIn(min = 250.dp),
                elevation = CardDefaults.cardElevation(4.dp)){
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "  Transportation Method", fontSize = 20.sp)
                ShowEachTransportation()
            }
        }
    }

}
@Composable
fun TransportationSelect(){
    var transports = listOf("10 min Taxi", "30 min Bus", "32 min MRT", "1h9min Walking")
    var selectedMode by remember { mutableStateOf(0) }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(transports) { index, mode ->
            Button(
                onClick = { selectedMode = index },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedMode == index) Color.Blue else Color.LightGray
                )
            ) {
                Text(text = mode, color = Color.White)
            }
        }
    }

}
@Composable
fun ShowEachTransportation(){
    var  transportationMethods = listOf("4min walk-->Ew-->riding(Total:25) \uD83D\uDC4D", "7min walk -->SW-->1walk(Total:36)","10min walk-->Bw-->Gw(Total:37)(raining today,  NOT RECOMMAND!!!)","wwwwww-->wwwwww...." )
    LazyColumn {
        items(transportationMethods.size) { index ->
            Column(
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth()
                    .shadow(10.dp, RoundedCornerShape(10.dp))
                    .background(Color.White ,shape = RoundedCornerShape(16.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = transportationMethods[index],
                    style = TextStyle(fontSize = 18.sp) ,
                    color = if (index == 0) Color.Red
                    else if (index ==2) Color.Gray else Color.Black
                )
            }
        }
    }
}



@Preview(showBackground = true, name = "map")
@Composable
fun MapShow(){
    MapView()

}
