package com.bitlogger.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp()
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceRoller()
}

@Composable
fun DiceRoller() {
    var result by remember { mutableStateOf(1) }

    val imageId = if (result == 1) {
        R.drawable.dice_1
    } else if (result == 2) {
        R.drawable.dice_2
    } else if (result == 3) {
        R.drawable.dice_3
    } else if (result == 4) {
        R.drawable.dice_4
    } else if (result == 5) {
        R.drawable.dice_5
    } else {
        R.drawable.dice_6
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dice Roller App", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(100.dp))
        Image(painter = painterResource(id = imageId), contentDescription = "Dice")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = "Roll Dice")
        }
    }
}