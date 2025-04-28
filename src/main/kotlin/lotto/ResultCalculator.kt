package lotto

object ResultCalculator {
    fun calculate(lottos: List<Lotto>, pickedNumbers: PickedNumbers, purchaseAmount: Int): Result {
        val rankCounts = lottos.groupingBy { lotto ->
            val matchCount = pickedNumbers.matchCountOf(lotto)
            val matchBonus = pickedNumbers.hasBonusNumber(lotto)
            Rank.from(matchCount, matchBonus)
        }.eachCount()

        return Result(rankCounts, purchaseAmount)
    }
}