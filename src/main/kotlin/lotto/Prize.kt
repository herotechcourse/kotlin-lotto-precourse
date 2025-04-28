package lotto

class Prize(
    val matchCount: Int, val isBonusRequired: Boolean, val amount: Int, val printText: String
) {
    fun isWinning(actualMatchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == actualMatchCount && isBonusRequired == isBonusMatched
    }
}