package lotto.domain

import lotto.Lotto

class LottoMachine(inputPurchaseAmount: String) {

    val numberOfLottos: Int
    val purchaseAmount: Int

    init {
        require(inputPurchaseAmount.isNotBlank()) { Lotto.ERROR_INPUT_EMPTY }
        purchaseAmount = inputPurchaseAmount.toIntOrNull()
            ?: throw IllegalArgumentException(Lotto.ERROR_NOT_VALID_NUMBER)
        require(purchaseAmount >= PURCHASE_UNIT) { ERROR_LESS_THAN_MINIMUM }
        require(purchaseAmount % PURCHASE_UNIT == 0) { ERROR_NOT_DIVISIBLE }
        numberOfLottos = purchaseAmount / PURCHASE_UNIT
    }

    companion object {
        private const val PURCHASE_UNIT = 1000
        private const val ERROR_LESS_THAN_MINIMUM = "[ERROR] Purchase amount must be at least $PURCHASE_UNIT."
        private const val ERROR_NOT_DIVISIBLE ="[ERROR] Purchase amount must be divisible by $PURCHASE_UNIT."

    }

    //OutputView
//    fun displayNumberOfTickets(numbers: Int){
//        println("\nYou have purchased $numbers tickets.")
//    }


}