package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}



@Preview
@Composable
fun LemonadeApp(modifier: Modifier= Modifier) {
    LemonadeWithButtonAndImage(modifier =Modifier
        .fillMaxSize()
        .wrapContentSize(align = Alignment.Center)
    )
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier) {
    val cont=(3..5).random()
    var click by remember{mutableIntStateOf (0)}
    var imageResource =R.drawable.lemon_tree
    val txtImg ={when (imageResource){
        R.drawable.lemon_tree->R.string.lemon_tree.toString()
        R.drawable.lemon_squeeze->R.string.lemon_description.toString()
        R.drawable.lemon_drink->R.string.glass_lemonade.toString()
        else->R.string.empty_glass.toString()
        }
    }

    val txtBtn =
        when (imageResource){
            R.drawable.lemon_tree->R.string.select_lemon.toString()
            R.drawable.lemon_squeeze->R.string.squeeze.toString()
            R.drawable.lemon_drink->R.string.drink.toString()
            else->R.string.start_again.toString()
        }
    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button (onClick ={click++} ) {
            Image (painter = painterResource(imageResource),
                contentDescription = (txtImg.toString())
            )
        }
        Spacer (modifier = Modifier.height(16.dp))
        Text (txtBtn)
    }
}

