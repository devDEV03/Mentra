package com.example.mentra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mentra.ui.theme.Purple40

@Composable
fun LoginPage(
    navCon : NavHostController,
    name : String
){
    Scaffold(
        topBar = {
         FloatingActionButton(onClick = { navCon.navigateUp() },modifier = Modifier.padding(10.dp)) {
             Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
         }   
        },
        containerColor = Color.LightGray
    ) {
        innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            var loginName by remember {
                mutableStateOf("")
            }
            var loginPass by remember {
                mutableStateOf("")
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){
                    Card(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 10.dp
                        )
                    ){
                        Column (
                            modifier = Modifier.padding(10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Box(
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
                            }
                            Text(text = name, style = MaterialTheme.typography.titleLarge)
                            Column(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Column {

                                    OutlinedTextField(
                                        value = loginName,
                                        onValueChange = {loginName = it},
                                        label = {
                                            Text(text = "Name")
                                        })
                                    Spacer(modifier = Modifier.height(10.dp))

                                    OutlinedTextField(
                                        value = loginPass,
                                        onValueChange = {loginPass = it},
                                        label = {
                                            Text(text = "Password")
                                        })
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Column (
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.fillMaxWidth()
                                ){
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "LOGIN")
                                    }
                                }
                            }

                        }
                    }

                }
            }
        }

    }

}


@Preview
@Composable
fun LoginPreview()
{
    LoginPage(navCon = rememberNavController(),"Dev")
}
