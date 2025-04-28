package lotto

object WinningNumberValidator {
    fun validate(input: String) {
        require(input.isNotBlank()) { "[ERROR] Input must not be blank." }

        val rawNumbers = input.split(",").map { it.trim() }

        require(rawNumbers.all { it.isNotBlank() }) { "[ERROR] Winning numbers must not contain blank values." }
        require(rawNumbers.all { it.toIntOrNull() != null }) { "[ERROR] Winning numbers must be integers." }

        val numbers = rawNumbers.map { it.toInt() }

        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Winning numbers must not contain duplicates." }
    }
}