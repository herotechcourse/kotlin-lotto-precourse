package lotto

data class WinningNumbers(val numbers: List<Int>, val bonus: Int) {
    init {
        require(numbers.size == 6 && numbers.toSet().size == 6 && numbers.all { it in 1..45 }) {
            "Winning numbers must be 6 unique numbers between 1 and 45"
        }
        require(bonus in 1..45 && bonus !in numbers) {
            "Bonus must be unique and between 1 and 45"
        }
    }
}
