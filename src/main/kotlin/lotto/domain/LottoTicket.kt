package lotto.domain

class LottoTicket(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] A LottoTicket must have exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] LottoTicket numbers must be unique." }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
}
