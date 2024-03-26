package me.dio.copa.catar.presentation.screens.matchitem

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.dio.copa.catar.domain.model.TeamDomain

@Composable
fun TeamItem(
    team: TeamDomain
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = team.flag,
            style = MaterialTheme.typography.h3.copy(color = Color.White)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = team.displayName,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5.copy(color = Color.White)
        )
    }
}