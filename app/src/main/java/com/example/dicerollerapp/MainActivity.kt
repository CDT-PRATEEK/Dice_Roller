package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                DiceRollerApp()

            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
) {
    var result by remember { mutableStateOf(1) }
    var imageresource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {

        Image(painter = painterResource(id = imageresource), contentDescription = result.toString()
        )
        Button (onClick = { result = (1..6).random() },elevation =
            ButtonDefaults.elevation(
            defaultElevation = 20.dp,
            pressedElevation = 15.dp
        )
        ){
            Text(stringResource(id = R.string.roll))

        }
    }

}}


