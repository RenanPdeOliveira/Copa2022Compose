package me.dio.copa.catar.presentation.match

import me.dio.copa.catar.domain.model.MatchDomain

data class MainUiState(
    val matches: List<MatchDomain> = emptyList()
)
