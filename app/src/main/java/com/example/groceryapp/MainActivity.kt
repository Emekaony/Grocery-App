package com.example.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroceryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnWithStickyHeader() {

    // create Data source
    val groupedItems = mapOf<String, List<String>>(
        "fruits" to listOf("Apple", "Bananas", "Cherry", "Mango", "Grape", "Watermelon"),
        "vegetables" to listOf("Carrot", "Lettuce", "Broccoli", "Spinach", "Tomato", "Cucumber"),
        "dairy" to listOf("Milk", "Cheese", "Yogurt", "Butter", "Sour Cream", "Cream Cheese"),
        "meat" to listOf("Beef", "Chicken", "Pork", "Lamb", "Turkey", "Fish"),
        "grains" to listOf("Rice", "Pasta", "Oats", "Quinoa"),
    )

    // create lazy column
    LazyColumn {
        groupedItems.forEach {  (header, items) ->
            stickyHeader {
                CustomHeader(header)
            }

            items(items) {item ->
                Text(text = item)
            }
        }
    }
}

@Composable
fun CustomHeader(title: String) {
    Text(
        title,
        fontSize = 32.sp,
        modifier = Modifier.fillMaxWidth()
        .background(color = Color.Red)
        .padding(8.dp)
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroceryAppTheme {
        Greeting("Android")
    }
}