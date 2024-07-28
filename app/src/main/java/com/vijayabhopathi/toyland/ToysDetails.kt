package com.vijayabhopathi.toyland

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vijayabhopathi.toyland.ui.theme.ToyTheme

class DetailedPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 390.dp)
            .requiredHeight(height = 844.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(brush = Brush.linearGradient(
                0.05f to Color(0xFF007CB4),
                1f to Color(0xFF03A9F4).copy(alpha = 0.81f),
                1f to Color(0xFFA2E2FF).copy(alpha = 0.48f),
                start = Offset(195f, 0f),
                end = Offset(195f, 844f)))
    ) {
        Text(
            text = "",
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 28.dp,
                    y = 607.dp))
        Text(
            text = "Toys 1 ",
            color = Color.Black.copy(alpha = 0.77f),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 22.dp,
                    y = 481.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 86.dp,
                    y = 97.dp)
                .requiredWidth(width = 238.dp)
                .requiredHeight(height = 222.dp)
                .background(brush = Brush.linearGradient(
                    0f to Color(0xffd9d9d9),
                    0.12f to Color(0xffd9d9d9).copy(alpha = 0.24f),
                    0.24f to Color(0xffd9d9d9).copy(alpha = 0.09f),
                    0.36f to Color(0xffd9d9d9).copy(alpha = 0.03f),
                    0.49f to Color(0xffd9d9d9),
                    0.61f to Color(0xffd9d9d9).copy(alpha = 0.02f),
                    0.69f to Color(0xffd9d9d9),
                    0.79f to Color(0xffd9d9d9).copy(alpha = 0.13f),
                    0.92f to Color(0xffd9d9d9).copy(alpha = 0.74f),
                    start = Offset(119f, 0f),
                    end = Offset(119f, 222f))))
        Text(
            text = " 4.0",
            color = Color(0xfffbf7f7),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 44.dp,
                    y = 422.dp)
                .requiredWidth(width = 51.dp)
                .requiredHeight(height = 40.dp))
        Text(
            text = "£40",
            color = Color(0xFF03A9F4),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 313.dp,
                    y = 424.dp))
        Text(
            text = "Dolls: Lifelike figures that nurture caregiving instincts and imaginative storytelling. Encourage social and emotional development in children.",
            color = Color(0xFFA0AFB6),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 5.dp,
                    y = 535.dp)
                .requiredWidth(width = 346.dp)
                .requiredHeight(height = 91.dp))



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToyTheme {
        Greeting("Android")
    }
}