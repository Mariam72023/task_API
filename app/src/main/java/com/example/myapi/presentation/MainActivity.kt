package com.example.myapi.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapi.presentation.ui.theme.MyAPITheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val composeViewModel by viewModels<ComposeViewModel>()
                    LaunchedEffect(key1 = true) {
                        composeViewModel.sharedFlow.collectLatest {
                            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
                        }
                    }
                    /*      Greeting(
                                              text = composeViewModel.textValue.value,
                                              onValueChange = { composeViewModel.textHasBeenWritten(it) })
                      */

                    Column {
                        Row {
                            Button(modifier = Modifier.weight(1f), onClick = {
                                composeViewModel.addProduct()
                            }) {
                                Text(text = "post product")
                            }
                            Button(modifier = Modifier.weight(1f), onClick = {
                                composeViewModel.loginToken()
                            }) {
                                Text(text = "get product")
                            }

                        /*    Button(modifier = Modifier.weight(1f), onClick = {
                                composeViewModel.updateProduct()
                            }) {
                                Text(text = "update product")
                            }*/
                            Button(modifier = Modifier.weight(1f), onClick = {
                                composeViewModel.deleteProduct()
                            }) {
                                Text(text = "delete pro")
                            }
                            Button(modifier = Modifier.weight(1f), onClick = {
                                composeViewModel.getUsers()
                            }) {
                                Text(text = "Get users")
                            }
                            Button(modifier = Modifier.weight(1f), onClick = {
                                composeViewModel.searchForProduct()
                            }) {
                                Text(text = "search pro")
                            }
                        }

                        LazyColumn(modifier = Modifier.fillMaxWidth()) {
                            items(composeViewModel.productList.value) {
                                ListItem(
                                    headlineText = { Text(text = it.headlineText) },
                                    supportingText = { Text(text = it.supportingText) })
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                        }
                    }


                    /*       Column(modifier = Modifier.fillMaxSize()) {
                                           BMListItem(
                                                text ={ Text(text = "Mariam", fontWeight = FontWeight.Bold)},
                                                secondaryText = { Text(text = "Student") },
                                               trailing = {Image(
                                                   painter = painterResource(R.drawable.ic_launcher_background ),
                                                   contentDescription ="", modifier = Modifier.size(30.dp)
                                               )}
                                               , modifier = Modifier.padding(8.dp)
                                            )
                                            CustomCheckBox(checked = composeViewModel.checked.value, onCheckChange = {
                                                composeViewModel.checked.value = it
                                                if (it) {
                                                    composeViewModel.textCheck.value = "checked"
                                                } else composeViewModel.textCheck.value = "unchecked"

                                            }, text = composeViewModel.textCheck.value)

                                        }
*/


                }
            }
        }
    }
}

@Composable
fun Greeting(text: String, onValueChange: (String) -> Unit) {

    Column(modifier = Modifier.padding(15.dp)) {
        CustomTextField(text = text,
            onTextChange = {
                onValueChange(it)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .background(Color.LightGray),

            label =
            { Text(text = "Enter name") },
            place = { Text(text = "Enter name") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Greeting(text = "", onValueChange = {})
}