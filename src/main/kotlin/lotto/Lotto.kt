package lotto
import lotto.support.*
import lotto.domain.Rank

class Lotto(private val numbers: List<Int>) {
init {
    require(numbers.toSet().size == TICKET_NUMBERS_COUNT) { Message.ERROR_WINNING_NUMBERS_DUPLICATE }
    require(numbers.size == TICKET_NUMBERS_COUNT) { Message.ERROR_LOTTO_NUMBERS_COUNT }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun getNumbers():List<Int> {
        return (numbers)
    }
}
