package com.harsh.baiscapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.harsh.baiscapp.main.MainNavigation
import com.harsh.baiscapp.main.PageScaffold

import com.harsh.baiscapp.main.SignupPage
import com.harsh.baiscapp.ui.theme.BaiscAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiscAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
//    MainNavigation()
    PageScaffold()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaiscAppTheme {
        Greeting()
    }
}