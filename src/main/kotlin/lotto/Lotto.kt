package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { (ExceptionMessage.INVALID_LOTTO_SIZE.message)}
        require(numbers.distinct().size == 6) { (ExceptionMessage.DUPLICATE_LOTTO_NUMBERS.message)}
        require(numbers.all { it in 1..45 }) { (ExceptionMessage.INVALID_LOTTO_RANGE.message) }

    }

    fun matchCount(winningNumbers: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val matchedNumbers = numbers.intersect(winningNumbers).size
        val matchedBonus = matchedNumbers == 5 && numbers.contains(bonusNumber)
        return Pair(matchedNumbers, matchedBonus)
    }

    fun getNumbers(): List<Int> = numbers
}
