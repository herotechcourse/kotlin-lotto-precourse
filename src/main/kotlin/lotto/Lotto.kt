package lotto

class Lotto(private val numbers: List<Int>) {
    private var bonusNumber: Int = 0

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto must contain unique numbers." }
        numbers.forEach {
            number -> require(number in 1..45) { "[ERROR] Lotto must contain numbers in range 1..45." }
        }
    }

    fun addBonusNumber(number: Int) {
        require(number !in numbers) { "[ERROR] Bonus number has to be different than winning numbers." }
        require(number in 1..45) { "[ERROR] Bonus number must be in range 1..45." }
        bonusNumber = number
    }

    // TODO: Implement additional functions
}
