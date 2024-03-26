package me.dio.copa.catar.presentation.screens.matchitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.domain.model.MatchDomain

@Composable
fun Teams(
    match: MatchDomain
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TeamItem(team = match.team1)
        Text(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            text = "x",
            style = MaterialTheme.typography.h6.copy(color = Color.White)
        )
        TeamItem(team = match.team2)
    }
}