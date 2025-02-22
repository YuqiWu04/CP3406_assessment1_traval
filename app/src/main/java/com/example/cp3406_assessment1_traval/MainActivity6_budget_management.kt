package com.example.cp3406_assessment1_traval
import androidx.compose.foundation.lazy.items
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cp3406_assessment1_traval.ui.theme.CP3406_assessment1_travalTheme
import androidx.compose.runtime.*

class MainActivity6_budget_management :  ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_assessment1_travalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BudgetManageView(modifier = Modifier.padding(innerPadding))
                    BottomNavigationBudgetUI()
                }
            }
        }
        }
    }

@Composable
fun BudgetManageView(modifier: Modifier = Modifier){
 Column(modifier = Modifier
     .fillMaxSize()
     .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally,){
     Box(modifier = Modifier
         .weight(0.5f)
         .fillMaxWidth()
         .background(Color(0xFF5EAA99)),
         contentAlignment = Alignment.TopCenter) {
         Column (){ MyTopAppBar()
             BudgetProgressPresentation()

             CurrencyExchange()

         }

     }
     Box(modifier = Modifier
         .weight(1f)
         .fillMaxWidth()
         .background(Color.White),
         contentAlignment = Alignment.Center) {
         PaymentContentDisplay()
     }
 }

}

@Composable
fun PaymentContentDisplay(){
    val payments = listOf(PaymentItem(
            "XXX Restaurant",
            500.00,
            "2023-04-01",
            "Food"
        ),
        PaymentItem(
            "Taxi Payment",
             100.00,
           "2023-04-02",
            "Transportation"
        ),
        PaymentItem(
             "Yacht",
             500.00,
             "2024-05-02",
             "Play"
        ),
        PaymentItem(
            "Bar Payment",
            1000.00,
            "2024-05-02",
            "Play"
        )
    )

    PaymentsShow(payments)

}
@Composable
fun CurrencyExchange(){
    var sourceCurrency by remember { mutableStateOf("1（USD）") }
    var targetCurrency by remember { mutableStateOf("0.97（EUR）") }
    var expandedSource by remember { mutableStateOf(false) }
    var expandedTarget by remember { mutableStateOf(false) }
    val currencies = listOf("USD", "EUR", "GBP", "CNY", "JPY")
Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
    Text(text = "Currency exchange", fontWeight = FontWeight.Bold)
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()){
        Box() {
            OutlinedButton(onClick = { expandedSource = true }) {
                Text(text = sourceCurrency)
            }
            DropdownMenu(
                expanded = expandedSource,
                onDismissRequest = { expandedSource = false },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                currencies.forEach { currency ->
                    DropdownMenuItem(
                        text = { Text(currency) },
                        onClick = {
                            sourceCurrency = currency
                            expandedSource = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(28.dp))
        Text(text = "--------->",fontWeight = FontWeight.Bold,)
        Spacer(modifier = Modifier.width(28.dp))
        Box {
            OutlinedButton(onClick = { expandedTarget = true }) {
                Text(text = targetCurrency)
            }
            DropdownMenu(
                expanded = expandedTarget,
                onDismissRequest = { expandedTarget = false },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                currencies.forEach { currency ->
                    DropdownMenuItem(
                        text = { Text(currency) },
                        onClick = {
                            targetCurrency = currency
                            expandedTarget = false
                        }
                    )
                }
            }
        }

    }
}



}

@Composable
fun BottomNavigationBudgetUI() {
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
        BudgetManageView(modifier = Modifier.padding(innerPadding))
    }
}
@Composable
fun PaymentsShow(payments: List<PaymentItem>){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(payments){payment->
            PaymentItemView(payment)
        }
    }
}
@Composable
fun PaymentItemView(payment: PaymentItem){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .heightIn(min = 150.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp),
    ){
        Row(modifier = Modifier.padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = payment.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "Amount: $${payment.amount}", fontSize = 16.sp, color = Color.Gray)
                Text(text = "Date: ${payment.date}", fontSize = 14.sp, color = Color.Gray)
                Text(text = "Category: ${payment.category}", fontSize = 14.sp, color = Color.Gray)

            }
            Text(text ="---$${payment.amount}",fontSize = 24.sp,fontWeight = FontWeight.Bold,modifier = Modifier.align(Alignment.CenterVertically) )
        }
    }
}
data class PaymentItem(
    val title: String,
    val amount: Double,
    val date: String,
    val category: String,
)

@Composable
fun BudgetProgressPresentation(){
    val progress = 0.5f
    Column(
        modifier = Modifier.padding(40.dp).background(Color(0XFF5EAA99)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Text(text = "Budget schedule: ${(progress * 100).toInt()}%", fontSize = 24.sp)
        LinearProgressIndicator(
            progress = {
                progress
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = Color.Red,
            trackColor = Color.LightGray,
        )
        Text(text = "Spendings: $9000.00/18000", fontSize = 20.sp)
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
        val context = LocalContext.current
        var expanded by remember { mutableStateOf(false) }

        TopAppBar(
            title = { Text("Budget Management", color = Color.Black, fontSize = 20.sp) },
            navigationIcon = {
                IconButton(onClick = { /* 菜单操作 */ }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
                }
            },
            actions = {
                Box {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.Black)
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Upload File/PDF") },
                            onClick = {
                                Toast.makeText(context, "Uploading File...", Toast.LENGTH_SHORT).show()
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Add New Item") },
                            onClick = {
                                Toast.makeText(context, "Adding New Item...", Toast.LENGTH_SHORT).show()
                                expanded = false
                            }
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF5EAA99),
            )
        )
    }

@Preview(showBackground = true, name = "Budget Management")
@Composable
fun BudgetManageDisplay(){
    BudgetManageView()
    BottomNavigationBudgetUI()
}

