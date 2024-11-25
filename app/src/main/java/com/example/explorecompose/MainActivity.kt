package com.example.explorecompose

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorInt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.explorecompose.ui.theme.ExploreComposeTheme
import com.example.explorecompose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploreComposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        ExpandableCard("Test card", "Figuring out how to make cards. Wasn't easy, but definitely worth the effort. It will make my life easier when I migrate my app to Compose")
                        GreetingEditTexts()
                    }
                }
            }
        }
    }
}

@Composable
fun CustomAnnotatedText(){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            ){
                append("A")
            }
            append("B")
            append("C")
            append("D")
        }
    )
}

@Composable
fun CustomSuperScriptText(
    normalText: String,
    superScriptText: String
){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                )
            ){
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Normal,
                    baselineShift = BaselineShift.Superscript
                )
            ){
                append(superScriptText)
            }
        }
    )
}

@Composable
fun CustomSubScriptText(
    normalText: String,
    subScriptText: String
){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                )
            ){
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Normal,
                    baselineShift = BaselineShift.Subscript
                )
            ){
                append(subScriptText)
            }
        }
    )
}

@Composable
fun GreetingNoBackgroundPadding(stringId : Int){
    Text(
        modifier = Modifier
            .padding(16.dp)
            .width(200.dp)
            .background(MaterialTheme.colorScheme.tertiary),
        text = stringResource(id = stringId),
        color = Color.White,
        style = Typography.headlineSmall,
        fontSize = 30.sp,
        textAlign = TextAlign.Center
        )
}

@Composable
fun GreetingEditTexts(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var nameText by remember { mutableStateOf("Enter your name") }
        var descriptionText by remember { mutableStateOf("Tell us something about yourself") }
        TextField(
            value = "This field cannot be changed",
            onValueChange = { },
            label = { Text("Uneditable Text") },
            singleLine = true,
            readOnly = true
        )
        TextField(
            value = nameText,
            onValueChange = { newText -> nameText = newText },
            label = { Text("First Name") },
            singleLine = true
        )
        TextField(
            value = descriptionText,
            onValueChange = { newText -> descriptionText = newText },
            label = { Text("About you") },
            maxLines = 4
        )
    }
}

@Composable
fun GreetingBackgroundPadding(stringId : Int){
    Text(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        text = stringResource(id = stringId),
        style = Typography.bodySmall,
        color = Color.White,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExploreComposeTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            GreetingNoBackgroundPadding(R.string.app_name)
            GreetingBackgroundPadding(R.string.app_greeting)
            GreetingBackgroundPadding(R.string.app_text)
            CustomAnnotatedText()
            CustomSuperScriptText(
                normalText = "Testing",
                superScriptText = "superscript text"
            )
            CustomSubScriptText(
                normalText = "Now testing",
                subScriptText = "subscript" )
            GreetingEditTexts()
        }
    }
}
