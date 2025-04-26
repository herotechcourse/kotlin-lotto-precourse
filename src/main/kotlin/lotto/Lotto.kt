package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto must not contain duplicated numbers" }
    }

    // find matches and determine the prize rank
    fun findMatches(winningNumbers: List<Int>, bonusNumber: Int): Prize {
        var sameNumberCount = numbers.intersect(winningNumbers.toSet()).size

        var prizeRank = when (sameNumberCount) {
            6 -> Prize.FirstPrize
            5 -> Prize.ThirdPrize
            4 -> Prize.FourthPrize
            3 -> Prize.FifthPrize
            else -> Prize.None
        }
        if (sameNumberCount == 5 && numbers.contains(bonusNumber))
            prizeRank = Prize.SecondPrize

        return prizeRank
    }

}
