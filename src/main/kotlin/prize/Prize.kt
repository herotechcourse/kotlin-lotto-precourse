package prize

import lotto.config.CURRENCY

data class Prize(
    private val matches: Int,
    private val bonus: Boolean,
    private val reward: Int
                 )
 {
     private var winCount: Int = 0

     fun increaseWinCount() {
        winCount++
     }

     fun award(): Int {
         return winCount * reward
     }

    override fun toString(): String {
        return "$matches Matches " +
                (if (bonus) "+ Bonus Ball " else "") +
                " (${String.format("%,d", reward)} ${CURRENCY}) - ${winCount} tickets"
    }

}