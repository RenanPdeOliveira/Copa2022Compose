package me.dio.copa.catar.presentation.match.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.dio.copa.catar.domain.model.MatchDomain
import me.dio.copa.catar.ui.theme.Shapes

@Composable
fun MatchItem(
    match: MatchDomain,
    notificationOnClick: (match: MatchDomain) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = Shapes.large
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.height(160.dp),
                model = match.stadium.image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                NotificationIcon(match, notificationOnClick)
                Title(match)
                Teams(match)
            }
        }
    }
}