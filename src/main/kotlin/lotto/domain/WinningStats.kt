package lotto.domain

import lotto.WinningRank

data class WinningStats(
    val stats: Map<WinningRank, Int>
)
