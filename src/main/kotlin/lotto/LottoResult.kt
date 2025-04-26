package lotto

class LottoResult(
    private var matchNum: Int,
    isMatchBonus: Boolean) {

    init {
        if ((matchNum == 5 && isMatchBonus) || matchNum == 6)
            matchNum++
    }

    private val prizeSet: List<Int> = listOf(0, 0, 0,
                                            5_000, 50_000, 1_500_500,
                                            30_000_000, 2_000_000_000)

    fun getPrize(): Int {
        return prizeSet[matchNum]
    }
}