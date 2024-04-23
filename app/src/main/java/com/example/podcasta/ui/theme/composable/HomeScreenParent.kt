package com.example.podcasta.ui.theme.composable

import android.media.session.PlaybackState
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.example.podcasta.repository.PodcastaRepository
import com.example.podcasta.ui.theme.PodcastaTheme
import androidx.compose.runtime.remember
import androidx.compose.material.icons.filled.Brightness6



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenParent() {
    PodcastList()
}

@ExperimentalMaterial3Api
@Composable
fun PodcastList() {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    val isDarkTheme = remember { mutableStateOf(isSystemInDarkTheme) }
    PodcastaTheme(
        darkTheme = isDarkTheme.value,
        dynamicColor = true
    ) {
        Scaffold(topBar = {
            Surface(shadowElevation = 5.dp) {
                TopAppBar(
                    title = {
                        Text(
                            text = "Podcast Player", // Замените на ваше название приложения
                            style = typography.titleLarge,
                            color = if (isDarkTheme.value) Color.White else Color.Black
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = if (isDarkTheme.value) Color.Black else Color.White
                    ),
                    actions = {
                        IconButton(onClick = { isDarkTheme.value = !isDarkTheme.value }) {
                            Icon(Icons.Filled.Brightness6, contentDescription = "Переключить тему")
                        }
                    }
                )

            }
        }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
                val podcastRepository = PodcastaRepository()
                val getAllDate = podcastRepository.getAllDate()

                Column {
                    LazyColumn(
                        modifier = Modifier.weight(weight = 1f),
                        contentPadding = PaddingValues(5.dp)
                    ) {
                        items(items = getAllDate) { podcast ->
                            PodcastItem(podcast = podcast, isDarkTheme = isDarkTheme.value)
                        }
                    }
                }



            AnimatedVisibility(
                        visible = false, // Замените на условие видимости
                        enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight })
                    ) {
                        // Здесь можно добавить контент для нижней панели
                    }
                }
            }
        }
    }


