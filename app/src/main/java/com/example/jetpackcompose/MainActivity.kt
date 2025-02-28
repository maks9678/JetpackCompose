package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
            )
            {//rememberScrollStaten сохраняет состояние
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                Button()
            }
        }
    }
}

@Composable
private fun Button() {
    var counter by remember { mutableIntStateOf(0) }
    var color by remember { mutableStateOf(Color.Blue) }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(
                color, shape = CircleShape
            )
            .clickable{
                when(++counter){
               10-> color=Color.Green
               20-> color=Color.Red}
            },
        contentAlignment = Alignment.Center,

    ) {
        Text(text = counter.toString(), style = TextStyle(color=Color.Yellow, fontSize = 20.sp))
    }
}


@Composable
private fun ListItem(name: String, prof: String) {
    var counter by remember { mutableIntStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                counter++
                Log.d("TAG", "ListItem: $counter")
            }
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, state ->
                    Log.d("TAG", "ListItem: $state")
                }

            } // отслеживаем любые действия с элементом
        ,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 18.dp)) {
                    Text(text = counter.toString())
                    Text(text = prof)
                }
            }
        }
    }

}