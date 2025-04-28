package lotto

class Result {
    private var firstPrize: Int = 0
    private var secondPrize: Int = 0
    private var thirdPrize: Int = 0
    private var fourthPrize: Int = 0
    private var fifthPrize: Int = 0
    private var rate: Float = 0f
    var totalPrice : Float = 0f

    fun calculateResult(winningLotto: WinningLotto, lottos: Lottos, purchaseAmount: String) {
        lottos.getTickets().forEach { lotto ->
            val matchCount = lotto.getNumbers().intersect(winningLotto.getWinningNumbers().toSet()).size
            val hasBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber())

            updateResult(matchCount, hasBonus)
        }

        if (totalPrice != 0f) {
            rate = (totalPrice / purchaseAmount.toFloat()) * 100
            return
        }
        rate = 0f
    }

    private fun updateResult(matchCount: Int, hasBonus: Boolean) {
        val rank = Rank.of(matchCount, hasBonus)
        if (rank.equals(Rank.FIRST)) {
            firstPrize += 1
            totalPrice += Rank.FIRST.prize
        }
        if (rank.equals(Rank.SECOND)) {
            secondPrize += 1
            totalPrice += Rank.SECOND.prize
        }
        if (rank.equals(Rank.THIRD)) {
            thirdPrize += 1
            totalPrice += Rank.THIRD.prize
        }
        if (rank.equals(Rank.FOURTH)) {
            fourthPrize += 1
            totalPrice += Rank.FOURTH.prize
        }
        if (rank.equals(Rank.FIFTH)) {
            fifthPrize += 1
            totalPrice += Rank.FIFTH.prize
        }
    }

    override fun toString(): String {
        return "3 Matches (5,000 KRW) – ${fifthPrize} tickets\n" +
                "4 Matches (50,000 KRW) – ${fourthPrize} tickets\n" +
                "5 Matches (1,500,000 KRW) – ${thirdPrize} tickets\n" +
                "5 Matches + Bonus Ball (30,000,000 KRW) – ${secondPrize} tickets\n" +
                "6 Matches (2,000,000,000 KRW) – ${firstPrize} tickets\n" +
                "Total return rate is ${"%.1f".format(rate)}%."
    }
}