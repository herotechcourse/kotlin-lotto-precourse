package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers.sorted() // For user entered Lotto numbers

    override fun toString(): String {
        return numbers.toString()
    }
}


