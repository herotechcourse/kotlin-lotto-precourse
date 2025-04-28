package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }

        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must not contain duplicates.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
    }
}
