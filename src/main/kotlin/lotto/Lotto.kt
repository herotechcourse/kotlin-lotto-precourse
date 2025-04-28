package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto must not contain duplicates numbers." }
    }

    fun getNumbers() : List<Int> {
        return numbers
    }
}
