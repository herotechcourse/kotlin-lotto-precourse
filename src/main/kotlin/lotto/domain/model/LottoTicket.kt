package lotto.domain.model

data class LottoTicket(val numbers: List<Int>) {
    fun countMatching(winningNumbers: List<Int>) :Int = numbers.count { it in winningNumbers }
    fun contains(number: Int) = number in numbers
}
