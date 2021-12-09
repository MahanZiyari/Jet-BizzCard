package com.mahan.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahan.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BizCard()
                }
            }
        }
    }
}

@Composable
fun BizCard() {
    var buttonClickedState by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(14.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 10.dp,
            border = BorderStroke(
                width = 1.dp,
                color = Color.LightGray
            )
        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                ProfileImage()
                Spacer(modifier = Modifier.height(2.dp))
                Divider(
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
                    thickness = 2.dp
                )
                CardInfo()
                Button(
                    onClick = {
                        buttonClickedState = !buttonClickedState
                    },
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                } // Button Scope
                if (buttonClickedState) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        ) {
            ProfileImage(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
            Column(
                modifier = Modifier
                    .padding(7.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = project.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Divider(
            startIndent = 80.dp
        )
    }
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(
                width = 2.dp,
                color = Color.LightGray
            )
        ) {
            // Portfolios will added here
            Portfolio(
                data = projectList
            )
        }
    }
}

@Composable
fun Portfolio(data: List<Project>) {
    LazyColumn {
        items(data) {
            ProjectItem(project = it)
        }
    }
}

@Composable
private fun CardInfo() {
    Column {
        NameText(
            name = "Mahan Ziyari"
        )
        InfoText("Junior Android Programmer")
        InfoText("@Arkham_King")
    }
}

@Composable
private fun InfoText(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier.padding(vertical = 4.dp),
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
private fun NameText(
    name: String,
    verticalPadding: Dp = 4.dp
) {
    Text(
        text = name,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(vertical = verticalPadding),
        color = MaterialTheme.colors.primaryVariant
    )
}

@Composable
private fun ProfileImage(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(
            width = 0.5.dp,
            color = Color.LightGray
        ),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun ProjectItemPreview() {

}

//@Preview
@Composable
fun ContentPreview() {
    Content()
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        BizCard()
    }
}