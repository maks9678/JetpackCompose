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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (modifier = Modifier
                .verticalScroll(rememberScrollState())
            )
            {//rememberScrollStaten сохраняет состояние
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
                ListItem("ЖЕЛЕЗНЫЙ ЧЕЛОВЕК", "Филантроп")
            }
        }
    }
}

@Composable
private fun ListItem(name: String, prof: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp).clickable{
                Log.d("TAG", "ListItem: $name")
            }
            .pointerInput(Unit){
                detectHorizontalDragGestures{change,state->
                    Log.d("TAG","ListItem: $state")
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
                    Text(text = name)
                    Text(text = prof)
                }
            }
        }
    }

}