package com.example.cp3406_assessment1_traval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme

class MainActivity5_booking_manager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_assessment1_travalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BookingManagerPageView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BookingManagerPageView(modifier: Modifier=Modifier){
    Column(modifier = Modifier.fillMaxSize()){
        MyTopApp()
        Spacer(modifier = Modifier.height(40.dp))
        BookingClassificationShow()
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Date: 01/11/2024 Booking Information", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(20.dp))
        BooingImageView()

    }

}
@Composable
fun BookingClassificationShow(){
  var BookingButtons = listOf("Sightseeing Tickets","Hotel","Air tickets", "Restaurant")
    var SelectedBookingButton by remember { mutableStateOf(0) }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(BookingButtons) { index, mode ->
            Button(
                onClick = { SelectedBookingButton = index },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (SelectedBookingButton == index) Color.Unspecified else Color.LightGray
                )
            ) {
                Text(text = mode, color = Color.White)
            }
        }
    }
}
data class ImageItem(
    val imageRes: Int,
    val title: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopApp() {
    TopAppBar(
        title = { Text("Your booking housekeeper！", color = Color.Black, fontSize = 20.sp) },
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.Black)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF5EAA99),
        ))
}
@Composable
fun BooingImageView() {
    val Tickets = listOf(
        ImageItem(R.drawable.zhiwuyuan, "2:00pm Botanical Garden"),
        ImageItem(R.drawable.weiduoliya, "9:30pm Night Boats") ,ImageItem(R.drawable.huanghelou, "5:00pm Yellow Crane Tower")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        items(Tickets) { ticket ->
            TicketImageCard(ticket)
        }
    }
}
@Composable
fun TicketImageCard(ticket:ImageItem){
    Card(
        modifier = Modifier.fillMaxSize()
            .size(200.dp)
            .padding(8.dp),

        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = ticket.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()

                    .height(120.dp).weight(2f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = ticket.title,
                modifier = Modifier.padding(8.dp),
                fontSize = 16.sp
            )
        }
    }
}
@Preview(showBackground = true, name = "booking manager page")
@Composable
fun BookingManagerPageShow(){
    BookingManagerPageView()
}