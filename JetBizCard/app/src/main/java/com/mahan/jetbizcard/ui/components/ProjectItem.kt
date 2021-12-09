package com.mahan.jetbizcard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahan.jetbizcard.Project

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

@Preview
@Composable
fun ProjectItemPreview() {
    ProjectItem(project = Project("Some Project"))
}