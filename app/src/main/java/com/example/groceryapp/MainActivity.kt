package com.example.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                    LazyColumnWithStickyHeader(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnWithStickyHeader(modifier: Modifier = Modifier) {

    // create Data source
    val foodItemMap: Map<String, List<Item>> = mapOf(
        "Fruits" to listOf(
            Item(
                title = "Apple",
                description = "The classic crisp and sweet snack.",
                image = R.drawable.woman_image
            ),
            Item(
                title = "Bananas",
                description = "Potassium-packed, perfect for energy.",
                image = R.drawable.woman_image
            ),
            Item(
                title = "Cherry",
                description = "Small, sweet, and bursting with flavor.",
                image = R.drawable.woman_image
            )
        ),

        "Vegetables" to listOf(
            Item(
                title = "Carrot",
                description = "Crunchy root vegetable, great for eyes.",
                image = R.drawable.woman_image
            ),
            Item(
                title = "Lettuce",
                description = "Leafy green base for any fresh salad.",
                image = R.drawable.woman_image
            ),
            Item(
                title = "Broccoli",
                description = "Nutrient-rich, miniature green trees.",
                image = R.drawable.woman_image
            )
        ),

        "Meat" to listOf(
            Item(
                title = "Beef",
                description = "Hearty red meat, excellent source of iron.",
                image = R.drawable.woman_image
            ),
            Item(
                title = "Chicken",
                description = "Versatile lean white protein.",
                image = R.drawable.woman_image
            ),
            Item(
                title = "Pork",
                description = "Flavorful meat, commonly used for bacon.",
                image = R.drawable.woman_image
            )
        )
    )

    // create lazy column
    LazyColumn (
        modifier = modifier.fillMaxSize()
    ) {
        foodItemMap.forEach { (header, items) ->
            stickyHeader {
                CustomHeader(header)
            }

            items(items) { item ->
                CustomCard(item)
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
        .background(color = Color.Green)
        .padding(8.dp)
    )
}

@Composable
fun CustomCard(item: Item) {
    Card (
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Image(
                painter = painterResource(item.image),
                contentDescription = "fruit image",
                modifier = Modifier.fillMaxWidth().height(180.dp),
                contentScale = ContentScale.Crop
            )
            Column (
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(item.title, fontSize = 22.sp)
                Text(item.description, fontSize = 18.sp)
            }
        }
    }
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
fun LazyColumnWithStickyHeaderPreview() {
    LazyColumnWithStickyHeader()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroceryAppTheme {
        Greeting("Android")
    }
}