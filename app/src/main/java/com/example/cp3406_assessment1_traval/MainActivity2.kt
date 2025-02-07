package com.example.cp3406_assessment1_traval
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
    val items = listOf("8:00am Singapore airline\n     Flight number: CA123", "12:00 check in \n     Location: Marina Bay Sands Hotel", "17:00pm ABC swimming poor\n     Location:Marina Square", "wwwwww\n" +
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
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .heightIn(min = 300.dp)
                .background(Color.White,shape  = RoundedCornerShape(35.dp))

        ) {
            // 可滚动或固定布局的容器
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Today's itinerary", style = MaterialTheme.typography.headlineLarge)

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "07/02/2025",
                    maxLines = 3
                )

                // 阅读更多
                TextButton(onClick = { /* 展开更多 */ }) {
                    Text(text = "Read More")
                }

                // 价格 + 按钮
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
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
                    .background(Color.White ,shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)){

                    Text(
                    text = "⚡\uFE0F${items[index]}",
                    fontSize = 20.sp,
                        color = Color.Black

                )
                    }


            }
        }
                }
            }
        }
    }
}

//    val items = listOf("8:00am Singapore airline\n     Flight number: CA123", "12:00 check in \n     Location: Marina Bay Sands Hotel", "17:00pm ABC swimming poor\n     Location:Marina Square", "20:00 Watch fireworks\n     Location: Marina Bay Sands Hotel")
//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Top,) {
//        Text(text = "Today's itinerary",
//            fontSize = 30.sp,
//            modifier =modifier ,
//            lineHeight = 28.sp,
//
//
//        )
//        Spacer(modifier = Modifier.height(50.dp))
//
//
//
//        LazyColumn {
//            items(items.size) { index ->
//                Box(
//                    modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//                    .background(Color.Gray ,shape = RoundedCornerShape(16.dp))
//                        .padding(16.dp)){
//
//                    Text(
//                    text = "⚡\uFE0F${items[index]}",
//                    fontSize = 20.sp,
//                        color = Color.White
//
//                )
//                    }
//
//
//            }
//        }
//    }
//}

@Preview(showBackground = true, name = "TravelDisplay")
@Composable
fun TravalShow(){
    CP3406_assessment1_travalTheme {
        TravelDisplay()
    }
}








