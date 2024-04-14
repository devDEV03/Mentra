package com.example.mentra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mentra.data.Screens
import com.example.mentra.data.modalList
import kotlinx.coroutines.launch




@Composable
fun MentraManager(
    navCon : NavHostController = rememberNavController()
){
    NavHost(navController = navCon, startDestination = Screens.Home.name){
        composable(Screens.Home.name){
            MentraApp(modifier = Modifier,navCon = navCon)
        }
        composable(Screens.LoginMentee.name){
            LoginPage(navCon = navCon, name = "Mentee Login")
        }
        composable(Screens.LoginMentor.name){
            LoginPage(navCon = navCon, name = "Mentor Login")
        }
        composable(Screens.Booking.name){
            BookACall(navCon = navCon)
        }
        composable(Screens.Details.name){
            MentorDetails(navCon = navCon)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentraApp(
modifier: Modifier,
navCon: NavHostController = rememberNavController()
){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItem by remember{
        mutableStateOf(0)
    }

    ModalNavigationDrawer(
        drawerContent = {
                ModalDrawerSheet{
                    Spacer(modifier.height(20.dp))
                    modalList.forEachIndexed { index, modalIconData ->
                        NavigationDrawerItem(
                            modifier = Modifier.clickable {
                                selectedItem = index
                                if(modalList[selectedItem].navRoute == Screens.LoginMentor.name){
                                    navCon.navigate(Screens.LoginMentor.name)
                                }
                            },
                            label = { Text(text = modalIconData.title,style = MaterialTheme.typography.bodyLarge) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            icon = {
                                IconButton(onClick = { selectedItem = index
                                if(modalList[selectedItem].navRoute == Screens.LoginMentor.name){
                                    navCon.navigate(Screens.LoginMentor.name)
                                }
                                }) {
                                    Icon(
                                        imageVector = if(selectedItem == index){
                                            modalIconData.selectedIconModal
                                        }
                                        else{
                                            modalIconData.unselectedIconModal
                                        },
                                        contentDescription = null
                                    )
                                }
                            }

                        )
                    }
                }


        },
        drawerState = drawerState
    ) {
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
                        IconButton(onClick = { scope.launch {
                            drawerState.open()
                        } }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = null )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Black,
                        navigationIconContentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            },
            bottomBar = {
                FloatingActionButton(onClick = { navCon.navigate(Screens.LoginMentor.name) },
                    modifier.padding(14.dp)) {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null)
                }
            }
        ) {
                innerPadding ->
            HomePage(modifier = Modifier.padding(innerPadding),navCon= navCon)
        }
    }
}

@Composable
private fun HomePage(
modifier : Modifier,
navCon: NavHostController
){
   Box(
       modifier = Modifier.fillMaxSize()
   ){
       Image(painter = painterResource(id = R.drawable.frame4), contentDescription = null, modifier = Modifier.fillMaxSize())
       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .fillMaxSize()
               .padding(top = 30.dp)
       ){
           Text(
               text = "Your Affordable Pathway to Top College Acceptance",
               modifier = Modifier.padding(top = 30.dp),
               style = MaterialTheme.typography.titleLarge,
               textAlign = TextAlign.Center
           )
           Text(
               text = "Expert Support for Your College Dreams!",
               modifier = Modifier.padding(top = 30.dp,bottom = 12.dp),
               style = MaterialTheme.typography.labelSmall,
               textAlign = TextAlign.Center
           )
           Spacer(modifier = Modifier.height(80.dp))
           Row(
               verticalAlignment = Alignment.CenterVertically
           ) {
               Button(onClick = { navCon.navigate(Screens.Booking.name) }) {
                   Text(text = "BOOK A CALL")
               }
               Spacer(modifier = Modifier.width(7.dp))
               Button(onClick = { navCon.navigate(Screens.LoginMentee.name)}) {
                   Text(text = "LOGIN/SIGN UP")
               }
           }
       }

   }
}

