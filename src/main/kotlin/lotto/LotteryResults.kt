package lotto

import lotto.PrizeRanking.*

class LotteryResults {
    fun getRank(matchCount: Int): Long {
        if (matchCount == 6)
            return FIRST.prize
        if (matchCount == 5)
            return THIRD.prize
        if (matchCount == 4)
            return FOURTH.prize
        if (matchCount == 3)
            return FIFTH.prize
        else
            return NONE.prize
    }

    fun formatPrize(number: Long): String{
        val formatter = java.text.DecimalFormat("#,###")
        return formatter.format(number)
    }
}