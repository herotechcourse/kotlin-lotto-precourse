package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun matchCount(winningNumbers: Set<Int>): Int {
        val count = numbers.count { it in winningNumbers }
        println("matchCount for ${numbers} and winningNumbers $winningNumbers is: $count")
        return count
    }


    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
}
