package com.example.podcasta


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.podcasta.repository.PodcastaRepository
import com.example.podcasta.ui.theme.PodcastaTheme
import com.example.podcasta.ui.theme.composable.HomeScreenParent
import com.example.podcasta.ui.theme.composable.PodcastItem
import com.example.podcasta.viewmodels.HomeViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember



class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            PodcastaTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                      HomeScreenParent(

                      )
                    }
                }
            }
        }
    }


