package lotto
import lotto.support.Message

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == REQUIRED_NUMBER_COUNT) { Message.ERROR_LOTTO_NUMBERS_COUNT }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    companion object {
        private const val REQUIRED_NUMBER_COUNT = 6
    }
}
