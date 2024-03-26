package me.dio.copa.catar.presentation

import me.dio.copa.catar.domain.model.MatchDomain

sealed interface MainUiAction {
    object Unexpected: MainUiAction
    data class MatchesNotFound(val message: String) : MainUiAction
    data class EnableNotification(val match: MatchDomain) : MainUiAction
    data class DisableNotification(val match: MatchDomain) : MainUiAction
}