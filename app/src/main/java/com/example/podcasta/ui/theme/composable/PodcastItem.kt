package com.example.podcasta.ui.theme.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.podcasta.R
import com.example.podcasta.repository.PodcastaRepository


@Composable
fun PodcastItem(podcast: PodcastModel, isDarkTheme: Boolean) {
    val backgroundColor = if (isDarkTheme) Color.Black else Color.White
    val textColor = if (isDarkTheme) Color.White else Color.Black
    val secondaryTextColor = if (isDarkTheme) Color.LightGray else Color.Gray

    Row(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = podcast.trackIcon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = podcast.name,
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = podcast.author,
                color = secondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = "Released on ${podcast.releaseDate}",
                color = secondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play",
            modifier = Modifier.size(24.dp),
            tint = textColor
        )
    }
}




@Composable
@Preview
fun PodcastItemPreview() {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    PodcastItem(
        podcast = PodcastModel(
            id = 0,
            trackIcon = R.drawable.ted_talks,
            name = "Let your garden grow wild",
            author = "Rebecca McMackin",
            releaseDate = "27 march"
        ),
        isDarkTheme = isSystemInDarkTheme
    )
}
