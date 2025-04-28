package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) {"[ERROR] All numbers must be unique."}
        require(numbers.all { it in 1..45 }) {"[ERROR] All numbers must be between 1 and 45."}
    }

    // returns ticket numbers sorted in ascending order
    fun getTicketNumbers(): List<Int> {
        return sortNumbers()
    }

    // returns the number of matching numbers with the winning numbers
    fun getMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count{ it in winningNumbers}
    }

    // checks if the bonus number is present in the ticket
    fun hasBonusNumber(bonusNumber: Int): Boolean{
        return numbers.contains(bonusNumber)
    }

    private fun sortNumbers(): List<Int>{
        return numbers.sorted()
    }
}
