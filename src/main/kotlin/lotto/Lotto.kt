package lotto

const val MAX_LOTTERY_NUMBERS = 6

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == MAX_LOTTERY_NUMBERS) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers

    fun countMatches(winningNumbers: List<Int>) = numbers.count { it in winningNumbers }

    fun hasNumber(number: Int) = number in numbers
}
