package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto must contain 6 unique numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    // TODO: Implement additional functions

    // Return the Lotto numbers sorted in ascending order
    fun getSortedNumbers(): List<Int> = numbers.sorted()

    // Count how many numbers match the winning numbers
    fun matchCount(winningNumbers: List<Int>): Int =

        // Count the number of matching numbers between the Lotto and the winning numbers
        numbers.count { it in winningNumbers }

    // Check if the Lotto numbers contain the bonus number
    fun containsBonus(bonus: Int): Boolean = bonus in numbers
}
