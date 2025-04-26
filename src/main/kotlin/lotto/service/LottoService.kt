package lotto.service

import lotto.exception.LottoInputException

object LottoService {
    fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0 || amount % 1000 != 0)
            throw LottoInputException.InvalidAmount(amount)
    }
}