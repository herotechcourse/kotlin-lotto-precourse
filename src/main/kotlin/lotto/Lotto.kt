package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers
}

object LottoConstants {
    const val TICKET_PRICE = 1000
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45
    const val LOTTO_NUMBER_COUNT = 6
}