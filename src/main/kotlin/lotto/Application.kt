package lotto

import camp.nextstep.edu.missionutils.Console

const val TICKET_PRICE = 1000;

fun main() {
    // Ticket Purchase Flow
    val purchaseAmount: Int = prompt_and_take_purchase_amount();
}

fun prompt_and_take_purchase_amount() : Int {
    while (true) {
        val purchasedAmount: Int
        try {
            purchasedAmount = Console.readLine().toInt()
            validate_purchase_amount(purchasedAmount)
            return purchasedAmount
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e: NumberFormatException) {
            println("[ERROR] Input must be a number")
        }
    }
}

fun validate_purchase_amount(purchaseAmount: Int) {
    // TODO
}