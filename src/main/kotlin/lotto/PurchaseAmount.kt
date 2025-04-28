package lotto

import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_INVALID_AMOUNT
import java.math.BigDecimal

class PurchaseAmount(private val amount: Int) {

    init{
        require(amount % 1000 == 0) { ERROR_MESSAGE_INVALID_AMOUNT }
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