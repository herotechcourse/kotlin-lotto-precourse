package prize

import lotto.config.CURRENCY
import lotto.config.bonusMap
import lotto.config.prizeMap

data class Prize(
    private val matches: Int,
    private val bonus: Boolean
                 )
 {
     private val reward: Int = if (bonus) {
         bonusMap[matches] ?: 0
     } else {
         prizeMap[matches] ?: 0
     }

     private var winCount: Int = 0

     fun increaseWinCount() {
        winCount++
    }

    override fun toString(): String {
        return "$matches Matches " +
                (if (bonus) "+ Bonus Ball " else "") +
                " (${String.format("%,d", reward)} ${CURRENCY}) - ${winCount} tickets"
    }

}