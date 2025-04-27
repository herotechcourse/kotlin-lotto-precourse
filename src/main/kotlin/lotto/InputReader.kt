package lotto

import lotto.views.InputView

class InputReader(private val inputView: InputView = InputView()){
    fun readPurchaseOrder(): Order {
        while (true) {
            try {
                val purchaseAmount = inputView.readPurchaseAmount().toInt()
                return Order(purchaseAmount)
            } catch (e: NumberFormatException) {
                println(Configuration.ErrorMessages.PURCHASE_AMOUNT_INVALID)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): Lotto {
        while (true) {
            try {
                val winningNumbers = inputView.readWinningNumbers().split(",").map { it.trim().toInt() }
                return Lotto(winningNumbers)
            } catch (e: NumberFormatException) {
                println(Configuration.ErrorMessages.WINNING_NUMBERS_INVALID)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber().toInt()
                require(bonusNumber in Configuration.MIN_NUMBER..Configuration.MAX_NUMBER) { Configuration.ErrorMessages.BONUS_NUMBER_INVALID_RANGE }
                return bonusNumber
            } catch (e: NumberFormatException) {
                println(Configuration.ErrorMessages.BONUS_NUMBER_INVALID)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}