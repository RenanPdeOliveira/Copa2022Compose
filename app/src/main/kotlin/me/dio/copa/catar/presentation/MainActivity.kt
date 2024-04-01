package me.dio.copa.catar.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import me.dio.copa.catar.extensions.observe
import me.dio.copa.catar.notification.scheduler.extensions.NotificationMatchWorker
import me.dio.copa.catar.presentation.match.MainScreen
import me.dio.copa.catar.presentation.match.MainUiAction
import me.dio.copa.catar.presentation.match.MainViewModel
import me.dio.copa.catar.ui.theme.Copa2022Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Copa2022Theme {
                observeAction()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val state by viewModel.state.collectAsState()
                    MainScreen(matches = state.matches, notificationOnClick = viewModel::toggleNotification)
                }
            }
        }
    }

    private fun observeAction() {
        viewModel.action.observe(this) { action ->
            when (action) {
                is MainUiAction.DisableNotification -> NotificationMatchWorker.cancel(applicationContext, action.match)
                is MainUiAction.EnableNotification -> NotificationMatchWorker.start(applicationContext, action.match)
                is MainUiAction.MatchesNotFound -> TODO()
                MainUiAction.Unexpected -> TODO()
            }
        }
    }
}
