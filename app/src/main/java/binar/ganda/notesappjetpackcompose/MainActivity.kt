package binar.ganda.notesappjetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import binar.ganda.notesappjetpackcompose.ui.theme.NotesAppjetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListNotes(NotesData.notesSample)
                }
            }
        }
    }
}

data class Notes(val id: Int, val title : String, val description : String)

@Composable
fun NotesCard(notes: Notes) {
        Column(modifier = Modifier.padding(15.dp)) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                backgroundColor = Color.LightGray,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = notes.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp, bottom = 10.dp)
                    )

                    Text(
                        text = notes.description,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
        }
}

@Preview(name = "Dark Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun PreviewNotesCard() {
        NotesCard(
            notes = Notes(1,"...", "...")
        )
}

@Composable
fun ListNotes(notes: List<Notes>){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(notes){ notes ->
            NotesCard(notes)
        }
    }
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun PreviewListNotes() {
    NotesAppjetpackcomposeTheme() {
        ListNotes(NotesData.notesSample)
    }
}