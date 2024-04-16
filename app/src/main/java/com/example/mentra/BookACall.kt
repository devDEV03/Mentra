package com.example.mentra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mentra.data.BookCardData
import com.example.mentra.data.Screens
import com.example.mentra.data.bookList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookACall(
    navCon : NavHostController
){
    
    var expanded1 by remember{
        mutableStateOf(false)
    }
    var expanded2 by remember{
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp,100.dp)
                        )

                },
                navigationIcon = {
                    FloatingActionButton(
                        onClick = { navCon.navigateUp() },
                        contentColor = Color.White,
                        containerColor = Color.Black) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        },
        modifier = Modifier.background(Color.Black)
    ) {
        innerPadding -> 
        Column (
            modifier = Modifier.padding(innerPadding)
        ){
            Box {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(12.dp).background(Color.Black)
                ) {
                    DropdownMenu(
                        expanded = expanded1,
                        onDismissRequest = { expanded1 = false },
                        content = {
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })

                        }
                    )
                    DropdownMenu(
                        expanded = expanded2,
                        onDismissRequest = { expanded2 = false },
                        content = {
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                            DropdownMenuItem(text = { Text(text = "item1") }, onClick = { /*TODO*/ })
                        }
                        )
                }
            }

            LazyVerticalGrid(columns = GridCells.Adaptive(256.dp),
                content = {
                    items(bookList){
                            it ->
                        Card(
                            modifier = Modifier
                                .padding(12.dp)
                                .clickable {
                                    navCon.navigate(Screens.Details.name)
                                }
                        ) {
                                Box {
                                    Image(painter = painterResource(it.photo), contentDescription = null)
                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxSize()
                                    ) {
                                        Row {
                                            Icon(imageVector = Icons.Outlined.Create, contentDescription = null)
                                            Text(text = it.name )
                                        }
                                        Row {
                                            Icon(imageVector = Icons.Outlined.Star, contentDescription = null)
                                            Text(text = it.almaMater )
                                        }
                                        Row {
                                            Icon(imageVector = Icons.Outlined.DateRange, contentDescription = null)
                                            Text(text = "00:00 am" )
                                        }
                                    }
                                }
                        }
                    }
                }
            )
        }
    }

}

@Preview
@Composable
fun BookCardDataPreview(
    navCon: NavHostController = rememberNavController()
){
    BookACall(navCon = navCon)
}