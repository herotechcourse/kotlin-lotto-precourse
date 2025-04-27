package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    // return matching numbers
    fun countMatch(winningNumbers: List<Int>): Int {
        var matchCount = 0
        for (number in numbers) {
            if (winningNumbers.contains(number)) {
                matchCount += 1
            }
        }
        return matchCount
    }

    // check bonus number in the lotto
    fun containsBonus(bonus: Int): Boolean {
        return numbers.contains(bonus)
    }
    // sorts the numbers in ascending order, then returns them as a string.
    override fun toString(): String {
        return numbers.sorted().toString()
    }
}
