package com.adrian.columnapp


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }

    @Preview
    @Composable
    fun ViewContainer() {
        Scaffold(
            topBar = { Toolbar()},
            content = { Content() },
            floatingActionButton = { Fav()},
            floatingActionButtonPosition = FabPosition.End
        )
    }

    @Composable
    fun Fav(){
        val context = LocalContext.current
        FloatingActionButton(onClick = { Toast.makeText(context , "Suscribete", Toast.LENGTH_SHORT).show() }) {
            Text(text = "X")
        }
    }

    @Composable
    fun Toolbar() {
        TopAppBar(
            title = { Text(text = "Column App", color = colorResource(id = R.color.white)) },
            backgroundColor = colorResource(id = R.color.background)
        )
    }


    @Composable
    fun Content() {
        var counter by rememberSaveable { mutableStateOf(0) }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            item {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Image"
                )
                Row(modifier = Modifier.padding(top = 8.dp)) {

                    Image(painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
                        contentDescription = "Image",
                        modifier = Modifier.clickable { counter++ })
                    Text(
                        text = counter.toString(),
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = "Hello World", fontSize = 32.sp, color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(text = "Hello World")
                Text(text = "Hello World")
                LazyRow(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    item {
                        Text(text = "Kotlin")
                        Text(text = "Java")
                        Text(text = "C ++")
                        Text(text = "Kotlin")
                        Text(text = "Java")
                        Text(text = "C ++")
                        Text(text = "C ++")
                        Text(text = "Kotlin")
                        Text(text = "Java")
                        Text(text = "C ++")
                        Text(text = "C ++")
                        Text(text = "C ++")
                        Text(text = "C ++")
                        Text(text = "C ++")
                        Text(text = "Kotlin")
                        Text(text = "Java")
                        Text(text = "C ++")
                        Text(text = "C ++")
                        Text(text = "C ++")
                    }
                }
            }
        }
    }


}


