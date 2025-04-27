package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.distinct().size) {"[ERROR] Lotto must contain no duplication."}
    }

    // TODO: Implement additional functions
    fun matchPrize(winningNumbers: List<Int>, bonusNumber: Int): Int {
        val matchedNumbers = numbers.intersect(winningNumbers).size
        val hasBonus = numbers.contains(bonusNumber)

        var prize = when (matchedNumbers) {
            6 -> 1
            5 -> 3
            4 -> 4
            3 -> 5
            else -> 6
        }

        if (hasBonus && matchedNumbers == 5) {
            prize = 2
        }

        return prize
    }
}
