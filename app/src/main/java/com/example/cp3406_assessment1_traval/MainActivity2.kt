package com.example.cp3406_assessment1_traval
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                }
            }
        }
    }
}
@Composable
fun TravelDisplay(modifier: Modifier = Modifier) {
    val items = listOf("8:00am Singapore airline\n     Flight number: CA123", "12:00 check in \n     Location: Marina Bay Sands Hotel", "17:00pm ABC swimming poor\n     Location:Marina Square", "20:00 Watch fireworks\n     Location: Marina Bay Sands Hotel")
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Top,) {
        Text(text = "Today's itinerary",
            fontSize = 30.sp,
            modifier =modifier ,
            lineHeight = 28.sp,


        )
        Spacer(modifier = Modifier.height(50.dp))



        LazyColumn {
            items(items.size) { index ->
                Box(
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.Gray ,shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)){

                    Text(
                    text = "⚡\uFE0F${items[index]}",
                    fontSize = 20.sp,
                        color = Color.White

                )
                    }


            }
        }
    }
}


@Preview(showBackground = true, name = "TravelDisplay")
@Composable
fun TravalShow(){
    CP3406_assessment1_travalTheme {
        TravelDisplay()
    }
}








