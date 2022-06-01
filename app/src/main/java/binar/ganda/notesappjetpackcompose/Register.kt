package binar.ganda.notesappjetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import binar.ganda.notesappjetpackcompose.ui.theme.NotesAppjetpackcomposeTheme

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Register("Android")
                }
            }
        }
    }
}

@Composable
fun Register(name: String) {

    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Text(
            text = "Register",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 40.dp)
        )

        val mContent = LocalContext.current
        var username by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            value = username,
            onValueChange = {username = it},
            label = { Text("Username") }
        )

        var name by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            value = name,
            onValueChange = {name = it},
            label = { Text("Name") }
        )

        var password by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            value = password,
            onValueChange = {password = it},
            label = { Text("Password") }
        )

        var confirm_password by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            value = confirm_password,
            onValueChange = {confirm_password = it},
            label = { Text("Confirm Password") }
        )

        Button(onClick = {
            mContent.startActivity(Intent(mContent, Login::class.java))
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = "Register")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    NotesAppjetpackcomposeTheme {
        Register("Android")
    }
}