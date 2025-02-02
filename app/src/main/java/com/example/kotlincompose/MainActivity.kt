package com.example.kotlincompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
 import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.KotlinComposeTheme

var PrimaryColor = Color.hsv(196F, 0.9F, 0.77F)
var current = "WeiCare"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (current){
                        "WeiCare" -> WeiCare()
                        "Contact" -> Contact()
                        "Notification" -> Notification()
                        "Me" -> Me()
                    }



                }
            }
        }
    }
}

@Composable
fun Notification() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.Bottom,

        ){
        Menubar()
    }


}

@Composable
fun WeiCare() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Bottom,

        ){
        Menubar()
    }

}


@Composable
fun Contact() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Bottom,

        ){
        Menubar()
    }

}


@Composable
fun Me() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Bottom,

        ){
        Menubar()
    }

}

@Composable
fun Menubar() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 75.dp)
            .background(color = PrimaryColor),

        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuItem(icon = Icons.Default.Home, name = "WeiCare")
        MenuItem(icon = Icons.Default.Person, name = "Contact")
        FloatingActionButton(
            modifier = Modifier
                .offset(y = (-20).dp)
                .size(75.dp),
            onClick = { /*TODO*/ },
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 5.dp),

            ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
        MenuItem(icon = Icons.Default.Notifications, name = "Notification")
        MenuItem(icon = Icons.Default.AccountCircle, name = "Me")
    }
}

@Composable
fun MenuItem(icon : ImageVector, name : String) {
    var active by remember { mutableStateOf("WeiCare") }

    IconButton(
        onClick = {
            active = name
        },
        modifier = Modifier.then(Modifier.size(75.dp))
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(imageVector = icon, modifier = Modifier.size(35.dp), contentDescription = null, tint = Color.White)
            Text(text = name, fontSize = 10.sp, color = Color.White)

        }



    }

}


//@Preview(showBackground = true)
//@Composable
//fun NotificationPreview() {
//    KotlinComposeTheme {
//        Notification()
//    }
//}

@Preview(showBackground = true)
@Composable
fun NotificationsPreview() {
    KotlinComposeTheme {
        Notification()
    }
}

@Preview(showBackground = true)
@Composable
fun NavbarPreview() {
    KotlinComposeTheme {
        Menubar()
    }
}


