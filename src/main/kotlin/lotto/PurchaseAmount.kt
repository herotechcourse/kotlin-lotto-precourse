package lotto

import java.math.BigDecimal

class PurchaseAmount(private val amount: Int) {

    init{
        require(amount % 1000 == 0) { "[ERROR] Amount must be a multiple of 1000" }
    }

    fun getNumberOfTickets(): Int {
        return amount / 1000
    }

    fun percentageOf(totalPrize: Int): BigDecimal {
        return BigDecimal(totalPrize)
            .multiply(BigDecimal(100))
            .divide(BigDecimal(amount))
    }
}