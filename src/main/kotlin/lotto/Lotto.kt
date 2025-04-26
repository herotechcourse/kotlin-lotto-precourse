package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT) { "[ERROR] Lotto must contain exactly $LOTTO_COUNT numbers." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER." }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
}
