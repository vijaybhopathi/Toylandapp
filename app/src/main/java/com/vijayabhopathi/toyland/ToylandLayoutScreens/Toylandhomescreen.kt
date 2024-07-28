package com.vijayabhopathi.toyland.ToylandLayoutScreens

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vijayabhopathi.toyland.CameraActivity
import com.vijayabhopathi.toyland.DetailedPageActivity

import com.vijayabhopathi.toyland.R
import com.vijayabhopathi.toyland.Modules.AppToolbar
import com.vijayabhopathi.toyland.Modules.NavigationDrawerBody
import com.vijayabhopathi.toyland.Modules.NavigationDrawerHeader

import com.vijayabhopathi.toyland.Toylanddata.Toylandhome.ToyViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: ToyViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                },
                navigationIconClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                  4  }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawerHeader(homeViewModel.emailId.value)
            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
                onNavigationItemClicked = {
                    Log.d("ComingHere","inside_NavigationItemClicked")
                    Log.d("ComingHere","${it.itemId} ${it.title}")
                })
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)

                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .requiredWidth(width = 420.dp)
                        .requiredHeight(height = 844.dp)
                        .clip(shape = RoundedCornerShape(40.dp))
                        .background(color = Color.Cyan)
                ) {


                    val context = LocalContext.current
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 31.dp, y = 112.dp)
                            .requiredWidth(width = 328.dp)
                            .requiredHeight(height = 46.dp)
                            .clickable {
                                context.startActivity(Intent(context,CameraActivity::class.java))
                            }
                            .clip(shape = RoundedCornerShape(30.dp))
                            .background(color = Color(0xFF03A9F4)))

                    Text(
                        text = "Profile",
                        color = Color(0xFFF7F8F8),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 51.dp, y = 123.dp)
                            .requiredWidth(width = 154.dp)
                            .requiredHeight(height = 43.dp))
                    Text(
                        text = "Information",
                        color = Color(0xFFF7F8F8),
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 150.dp, y = 123.dp)
                            .requiredWidth(width = 154.dp)
                            .requiredHeight(height = 43.dp))

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 31.dp,
                                y = 191.dp)
                            .requiredWidth(width = 72.dp)
                            .requiredHeight(height = 66.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(color = Color(0xFF03A9F4)))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 113.dp,
                                y = 191.dp)
                            .requiredWidth(width = 72.dp)
                            .requiredHeight(height = 66.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(color = Color(0xffdad1e0)))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 195.dp,
                                y = 191.dp)
                            .requiredWidth(width = 72.dp)
                            .requiredHeight(height = 66.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(color = Color(0xffd4ced9)))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 277.dp,
                                y = 191.dp)
                            .requiredWidth(width = 72.dp)
                            .requiredHeight(height = 66.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(color = Color(0xffd5cfda)))
                    val localContext = LocalContext.current
                    Text(
                        text = "All",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 18.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 53.dp,
                                y = 264.dp))




                    Image(
                        painter = painterResource(id = R.drawable.rectangle8),
                        contentDescription = "Rectangle 6",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 17.dp,
                                y = 340.dp)
                            .requiredWidth(width = 165.dp)
                            .requiredHeight(height = 200.dp)
                            .clip(shape = RoundedCornerShape(20.dp)))
                    Image(
                        painter = painterResource(id = R.drawable.rectangle8),
                        contentDescription = "Rectangle 7",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 196.dp,
                                y = 340.dp)
                            .requiredWidth(width = 163.dp)
                            .requiredHeight(height = 200.dp)
                            .clip(shape = RoundedCornerShape(20.dp)))
                    Image(
                        painter = painterResource(id = R.drawable.rectangle8),
                        contentDescription = "Rectangle 8",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 17.dp,
                                y = 566.dp)
                            .requiredWidth(width = 165.dp)
                            .requiredHeight(height = 200.dp)
                            .clip(shape = RoundedCornerShape(20.dp)))
                    Image(
                        painter = painterResource(id = R.drawable.rectangle8),
                        contentDescription = "Rectangle 9",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 196.dp,
                                y = 566.dp)
                            .requiredWidth(width = 163.dp)
                            .requiredHeight(height = 200.dp)
                            .clip(shape = RoundedCornerShape(20.dp)))

                    Text(
                        text = "Toy1",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 44.dp,
                                y = 475.dp))
                    Text(
                        text = "Toy2",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 218.dp,
                                y = 475.dp))
                    Text(
                        text = "Toy3",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 44.dp,
                                y = 692.dp))
                    Text(
                        text = "Toy4",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 218.dp,
                                y = 690.dp))
                    Text(
                        text = "$80",
                        color = Color(0xFF03A9F4),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 33.dp, y = 508.dp)
                            .requiredWidth(width = 65.dp)
                            .requiredHeight(height = 34.dp))
                    Text(
                        text = "$70",
                        color = Color(0xFF03A9F4),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 206.dp, y = 510.dp)
                            .requiredWidth(width = 65.dp)
                            .requiredHeight(height = 34.dp))
                    Text(
                        text = "$90",
                        color = Color(0xFF03A9F4),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 33.dp, y = 719.dp)
                            .requiredWidth(width = 65.dp)
                            .requiredHeight(height = 34.dp))
                    Text(
                        text = "$80",
                        color = Color(0xFF03A9F4),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 206.dp, y = 722.dp)
                            .requiredWidth(width = 65.dp)
                            .requiredHeight(height = 34.dp))
                    Image(
                        painter = painterResource(id = R.drawable.to1),
                        contentDescription = "Toy1",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 31.dp,
                                y = 348.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailedPageActivity::class.java)
                                )
                            }
                            .requiredWidth(width = 141.dp)
                            .requiredHeight(height = 126.dp))

                    Image(
                        painter = painterResource(id = R.drawable.to2),
                        contentDescription = "Toy2",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 158.dp,
                                y = 360.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailedPageActivity::class.java)
                                )
                            }
                            .requiredWidth(width = 220.dp)
                            .requiredHeight(height = 100.dp))
                    Image(
                        painter = painterResource(id = R.drawable.to3),
                        contentDescription = "Toy3",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 31.dp,
                                y = 566.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailedPageActivity::class.java)
                                )
                            }
                            .requiredWidth(width = 141.dp)
                            .requiredHeight(height = 126.dp))

                    Image(
                        painter = painterResource(id = R.drawable.to4),
                        contentDescription = "Toy4",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 199.dp,
                                y = 597.dp)
                            .clickable {
                                localContext.startActivity(
                                    Intent(localContext, DetailedPageActivity::class.java)
                                )
                            }
                            .requiredWidth(width = 170.dp)
                            .requiredHeight(height = 89.dp))

                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()

    val context = LocalContext.current

    if (Build.VERSION.SDK_INT >= 23) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("hhhh", "Permissions not granted")
            Toast.makeText(context, "This app needs the Location permission, Accept to use location functionality", Toast.LENGTH_SHORT).show()

            // ask for permission
            ActivityCompat.requestPermissions(Activity(), arrayOf( Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }else{
            Toast.makeText(context, "Location permission, Accepted", Toast.LENGTH_SHORT).show()
        }
    }


}