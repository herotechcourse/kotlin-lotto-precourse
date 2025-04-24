package lotto

import camp.nextstep.edu.missionutils.Console

const val TICKET_PRICE = 1000;

fun main() {
    // Ticket Purchase Flow
    val amount: Int = promptAndTakeAmount();
}

fun promptAndTakeAmount() : Int {
    while (true) {
        val input = promptInput("Please enter the purchase amount.")
        val amount = parseInputToInt(input) ?: continue
        if (validateAmountOrShowError(amount)) return amount
    }
}

fun promptInput(msg: String) : String {
    println(msg)
    return Console.readLine()
}

fun parseInputToInt(input: String?) : Int? = try {
    input?.toInt()
} catch (e: NumberFormatException) {
    println("[ERROR] Input must be a number")
    null
}

fun validateAmountOrShowError(amount: Int) : Boolean = try {
    validateAmount(amount)
    true
} catch (e: IllegalArgumentException) {
    println(e.message)
    false
}

fun validateAmount(amount: Int) {
    if (amount <= 0) throw IllegalArgumentException("[ERROR] Amount must be positive.")
    if (amount % TICKET_PRICE != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
}
