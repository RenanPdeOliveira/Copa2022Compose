package me.dio.copa.catar.presentation.match.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import me.dio.copa.catar.R
import me.dio.copa.catar.domain.model.MatchDomain

@Composable
fun NotificationIcon(
    match: MatchDomain,
    onClick: (match: MatchDomain) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        val drawableInfo =
            if (match.notificationEnabled) R.drawable.ic_notifications_active else R.drawable.ic_notifications
        Image(
            modifier = Modifier
                .clickable {
                    onClick(match)
                },
            painter = painterResource(id = drawableInfo),
            contentDescription = null
        )
    }
}