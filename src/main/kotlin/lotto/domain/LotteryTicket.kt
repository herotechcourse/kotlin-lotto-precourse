package lotto.domain

class LotteryTicket(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    companion object {
        val CURRENCY: CurrencyType = CurrencyType.KRW
        const val PRICE: Int = 1_000
    }
}
