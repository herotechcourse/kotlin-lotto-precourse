package lotto
import lotto.domain.Settings

class Lotto(private val numbers: List<Int>) {

    private object ErrorMessage {
        const val INVALID_LENGTH = "[ERROR] Lotto must contain exactly 6 numbers."
        const val INVALID_RANGE = "[ERROR] Lotto numbers must be between 1 and 45."
        const val FOUND_DUPLICATE = "[ERROR] Lotto numbers must be unique."
        const val INVALID_ORDER = "[ERROR] Lotto numbers must be sorted."
    }

    init {
        require(numbers.size == Settings.TICKET_LEN) { ErrorMessage.INVALID_LENGTH }
        require(numbers.all { it in Settings.MIN_RANGE..Settings.MAX_RANGE }) { ErrorMessage.INVALID_RANGE }
        require(numbers.distinct().size == numbers.size) { ErrorMessage.FOUND_DUPLICATE }
        require(numbers.sorted() == numbers) { ErrorMessage.INVALID_ORDER }
    }

    fun matchCount(winningNumbers: List<Int>): Int =
        numbers.count { it in winningNumbers }

    fun contains(number: Int): Boolean =
        number in numbers

    fun getNumbers(): List<Int> = numbers

}
