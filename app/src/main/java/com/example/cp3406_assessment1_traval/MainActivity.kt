package com.example.cp3406_assessment1_traval
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_assessment1_travalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    LogPageImage(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight().padding(10.dp)) {
        Text(
            text = "Login",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email or Username") }, modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { password = it },
            label = { Text("Password") }, modifier = Modifier.fillMaxWidth()

        )
        Button(
            onClick = {

            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Login")
        }
        Text(
            text = "Forgot your password? "
        )
    }


}

@Preview(showBackground = true,name = "Log in page")
@Composable
fun UserInput() {
    CP3406_assessment1_travalTheme {
        LogPageImage()
    }
}
@Composable
fun LogPageImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.lo)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 1F
        )
        Login()
    }

}
