package com.vijayabhopathi.toyland

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vijayabhopathi.toyland.ui.theme.ToyTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

class OrdersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 375.dp)
            .requiredHeight(height = 812.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 121.dp,
                    y = 799.dp)
                .requiredWidth(width = 134.dp)
                .requiredHeight(height = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .offset(x = 0.dp,
                        y = 0.dp)
                    .requiredWidth(width = 134.dp)
                    .requiredHeight(height = 5.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
                    .background(color = Color(0xff222325)))
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 20.dp,
                    y = 64.dp)
                .requiredWidth(width = 219.dp)
                .requiredHeight(height = 22.dp)
        ) {

            Text(
                text = "Order Details",
                color = Color(0xff222325),
                textAlign = TextAlign.Center,
                lineHeight = 1.29.em,
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.5).sp
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 20.dp,
                    y = 111.dp)
                .requiredWidth(width = 335.dp)
                .requiredHeight(height = 156.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 335.dp)
                    .requiredHeight(height = 156.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 335.dp)
                        .requiredHeight(height = 156.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 335.dp)
                            .requiredHeight(height = 156.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(color = Color.White))
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 335.dp)
                            .requiredHeight(height = 40.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 335.dp)
                                .requiredHeight(height = 40.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(color = Color.White))

                        Text(
                            text = "Order Id : #456789",
                            color = Color(0xff222325),
                            textAlign = TextAlign.Center,
                            lineHeight = 10.46.em,
                            style = TextStyle(
                                fontSize = 13.sp,
                                letterSpacing = (-0.24).sp
                            ),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 15.dp,
                                    y = 11.dp
                                )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 15.dp,
                            y = 98.dp)
                        .requiredWidth(width = 306.dp)
                        .requiredHeight(height = 36.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 27.dp,
                                y = 0.dp)
                            .requiredWidth(width = 279.dp)
                            .requiredHeight(height = 36.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 279.dp)
                                .requiredHeight(height = 36.dp)
                        ) {



                            Text(
                                text = "10/2, uk",
                                color = Color(0xff222325),
                                lineHeight = 13.17.em,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    letterSpacing = (-0.24).sp
                                ),
                                modifier = Modifier
                                    .requiredWidth(width = 279.dp)
                                    .requiredHeight(height = 36.dp)
                            )
                        }
                    }
//
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 15.dp,
                            y = 55.dp)
                        .requiredWidth(width = 305.dp)
                        .requiredHeight(height = 25.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 27.dp,
                                y = 2.dp)
                            .requiredWidth(width = 82.dp)
                            .requiredHeight(height = 20.dp)
                    ) {
                        Text(
                            text = "Vijayabhopathi\n",
                            color = Color(0xff222325),
                            lineHeight = 13.17.em,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = (-0.24).sp
                            ),
                            modifier = Modifier
                                .requiredWidth(width = 82.dp)
                                .requiredHeight(height = 20.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 248.dp,
                                y = 0.dp)
                            .requiredWidth(width = 57.dp)
                            .requiredHeight(height = 25.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 57.dp)
                                .requiredHeight(height = 25.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(color = Color(0xFF03A9F4)))
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 10.dp,
                                    y = 3.dp)
                                .requiredWidth(width = 38.dp)
                                .requiredHeight(height = 19.dp)
                        ) {
                            Text(
                                text = "Call",
                                color = Color.White,
                                lineHeight = 13.17.em,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    letterSpacing = (-0.24).sp
                                ),
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(
                                        x = 15.64453125.dp,
                                        y = 0.dp
                                    )
                            )
                            Image(
                                painter = painterResource(id = R.drawable.group2685),
                                contentDescription = "Group 676",
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(x = 0.dp,
                                        y = 4.dp)
                                    .requiredWidth(width = 10.dp)
                                    .requiredHeight(height = 11.dp))
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 217.dp,
                        y = 11.dp)
                    .requiredWidth(width = 103.dp)
                    .requiredHeight(height = 18.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 86.dp)
                        .requiredHeight(height = 18.dp)
                ) {
                    Text(
                        text = "Delivery Items",
                        color = Color(0xff222325),
                        textAlign = TextAlign.End,
                        lineHeight = 10.46.em,
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = (-0.24).sp
                        )
                    )
                }
//
            }
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 20.dp,
                    y = 287.dp)
                .requiredWidth(width = 335.dp)
                .requiredHeight(height = 42.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 106.9130859375.dp,
                        y = 9.dp)
                    .requiredWidth(width = 119.dp)
                    .requiredHeight(height = 24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image27),
                    contentDescription = "6",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 10.dp,
                            y = 171.dp)
                        .requiredWidth(width = 400.dp)
                        .requiredHeight(height = 400.dp))
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 25.dp)
                        .requiredHeight(height = 24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 25.dp)
                            .requiredHeight(height = 24.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 25.dp)
                                .requiredHeight(height = 24.dp)
                                .background(color = Color.White))
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 20.dp,
                    y = 376.dp)
                .requiredWidth(width = 335.dp)
                .requiredHeight(height = 42.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 335.dp)
                    .requiredHeight(height = 42.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 335.dp)
                        .requiredHeight(height = 42.dp)
                ) {
                    val context = LocalContext.current
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 335.dp)
                            .requiredHeight(height = 42.dp)
                            .clickable {
                                context.startActivity(Intent(context,Deliverysucess::class.java))
                            }
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(color = Color(0xFF03A9F4)))
                }






                Text(
                    text = "Delivery Completed ",
                    color = Color.White,
                    textAlign = TextAlign.End,
                    lineHeight = 9.72.em,
                    style = TextStyle(
                        fontSize = 14.sp,
                        letterSpacing = (-0.24).sp
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(
                            x = 115.dp,
                            y = 11.dp
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ToyTheme {
        Greeting2("Android")
    }
}