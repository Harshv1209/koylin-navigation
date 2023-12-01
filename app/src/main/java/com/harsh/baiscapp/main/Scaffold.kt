package com.harsh.baiscapp.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.harsh.baiscapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageScaffold() {
    Scaffold(
        topBar = {

            TopAppBar(
                title = { Text(text = "Page Title")

                },
                actions = {
                    IconButton(onClick = { /* Handle action 1 click */ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                    IconButton(onClick = { /* Handle action 2 click */ }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    }
                }

            )

        },
                bottomBar = {
            BottomAppBar() {
                Text(text = "This is the Bottom Bar")
            }
        },
                        floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* Handle floating action button click */ }
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Content of the Page",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.displayMedium
            )
           Image(painter = painterResource(R.drawable.profile_image), contentDescription = " ")
        }
    }
}