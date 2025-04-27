package lotto

import lotto.views.InputView

class InputReader(private val inputView: InputView = InputView()){
    fun readPurchaseOrder(): Order {
        while (true) {
            try {
                val purchaseAmount = inputView.readPurchaseAmount().toInt()
                return Order(purchaseAmount)
            } catch (e: NumberFormatException) {
                println("[ERROR] Purchase amount must be a valid number.")
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
                println("[ERROR] Winning numbers must be valid integers.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber().toInt()
                require(bonusNumber in MIN_NUMBER..MAX_NUMBER) { "[ERROR] Bonus number must be between $MIN_NUMBER and $MAX_NUMBER." }
                // TODO: Check if the bonus number is unique and not in the winning numbers
                return bonusNumber
            } catch (e: NumberFormatException) {
                println("[ERROR] Bonus number must be a valid integer.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}