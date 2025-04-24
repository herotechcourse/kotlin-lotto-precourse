package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val WINNER_NUMBER_COUNT = 6
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    private const val TICKET_PRICE = 1000

    fun input(): String {
        return Console.readLine()
    }

    fun purchaseAmountInput(amount: Int): Int {
        if(amount % TICKET_PRICE != 0) {
            throw IllegalArgumentException("Amount must be divisible by 1000.")
        }
        if(amount < 0) {
            throw IllegalArgumentException("Amount must be positive.")
        }

        return amount / TICKET_PRICE
    }


}