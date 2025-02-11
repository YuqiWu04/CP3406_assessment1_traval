package com.example.cp3406_assessment1_traval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme

class MainActivity7_notification : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            CP3406_assessment1_travalTheme{
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NotificationView(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun NotificationView(modifier: Modifier = Modifier){
Box( modifier = Modifier
    .fillMaxSize()
    .padding(bottom = 8.dp)
    .background(Color(0xFF5EAA99))){
    Image(
        painter = painterResource(id = R.drawable.smartplane),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    )
        Text(text = "Important Notification",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            lineHeight = 50.sp,color = Color.White,
            modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 28.dp) )
    Spacer(modifier = Modifier.height(8.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .heightIn(min = 500.dp),
            elevation = CardDefaults.cardElevation(4.dp)){
            Spacer(modifier = Modifier.height(8.dp))
            NavigationBarsShow()
            NotificationDetailShow()
        }





}

}
@Composable
fun NavigationBarsShow(){
    var BookingButtons = listOf("Itinerary and schedule","Transportation","Weather", "Travel preparation")
    var SelectedBookingButton by remember { mutableStateOf(0) }
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(BookingButtons) { index, mode ->
            Button(
                onClick = { SelectedBookingButton = index },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (SelectedBookingButton == index) Color(0xFF5EAA99) else Color.White

                )
            ) {
                Text(text = mode, color = Color.Black)
            }
        }
    }

}

@Composable
fun NotificationDetailShow(){
    val notifications = listOf("  With 3 hours left to travel to the nearest yachting attraction, get there as soon as possible and click on the %% link to Google MAP to search for the fastest trip!","  You have a flight itinerary for 20 January 2025 at 8:00 p.m. Attention.","  You have a ticket for the Chinese Art Museum booked for 23 January 2025 at 12 noon.","  You have a reservation for 25 January 2025 at 11:00 p.m. at the xxhotel, please note")

    LazyColumn(modifier = Modifier
        .height(400.dp)
        .clipToBounds()) {
        items(notifications.size) { index ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

                    .shadow(10.dp, RoundedCornerShape(10.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = notifications[index],
                    fontSize = 20.sp,
                    color =if (index  == 0) Color.Red else Color.Black,
                    fontWeight = if (index == 0) FontWeight.Bold else FontWeight.Normal,

                )
            }
        }
    }


}


@Preview(showBackground = true, name = "Notification")
@Composable
fun NotificationShow() {
    NotificationView()
}