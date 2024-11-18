package com.example.explorecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.explorecompose.ui.theme.ExploreComposeTheme
import com.example.explorecompose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploreComposeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                }
            }
        }
    }
}

@Composable
fun ColumnScope.CustomItem(width : Int, height : Int, weight : Float, color : Color){
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .width(width.dp)
            .height(height.dp),
        color = color
    ) {}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExploreComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            CustomItem(width = 200, height = 100, weight = 3f, color = MaterialTheme.colorScheme.primary)
            CustomItem(width = 100, height = 100, weight = 3f, color = MaterialTheme.colorScheme.secondary)
            CustomItem(width = 50, height = 100, weight = 3f, color = MaterialTheme.colorScheme.tertiary)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
                    .width(150.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {}
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(3f)
                    .width(150.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {}
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(2f)
                    .width(150.dp),
                color = MaterialTheme.colorScheme.tertiaryContainer
            ) {}
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        )
        {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .height(350.dp)
                    .width(20.dp),
                color = MaterialTheme.colorScheme.inversePrimary
            ) {}
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .height(350.dp)
                    .width(30.dp),
                color = MaterialTheme.colorScheme.errorContainer
            ) {}
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .height(350.dp)
                    .width(100.dp),
                color = MaterialTheme.colorScheme.error
            ) {}
        }
    }
}