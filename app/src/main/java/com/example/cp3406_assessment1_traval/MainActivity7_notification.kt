package com.example.cp3406_assessment1_traval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

}

@Preview(showBackground = true, name = "Notification")
@Composable
fun NotificationShow() {
    NotificationView()
}