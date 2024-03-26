package me.dio.copa.catar.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.dio.copa.catar.domain.model.MatchDomain
import me.dio.copa.catar.presentation.screens.matchitem.MatchItem

@Composable
fun MainScreen(
    matches: List<MatchDomain>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(matches) { match ->
                MatchItem(match = match)
            }
        }
    }
}