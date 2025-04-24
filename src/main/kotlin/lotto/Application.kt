package lotto

import camp.nextstep.edu.missionutils.Console

fun readPurchaseAmount(): Int? {
    println("Please enter the purchase amount.")
    val userInput = Console.readLine()
    val purchaseAmount = userInput.toIntOrNull()
    if  (purchaseAmount == null) {
        println("[ERROR] purchase amount must be an integer")
        return null
    }
    return  purchaseAmount
}

fun validatePurchaseAmount(amount: Int){
    if (amount <= 0) {
        println("[ERROR] Amount must be a positive number.")
        throw IllegalArgumentException()
    }
    if (
        amount % 1000 != 0
    ) {
        println("[ERROR] Each ticket costs 1,000 KRW")
        throw IllegalArgumentException()
    }
}

fun main() {
    val amount = readPurchaseAmount() ?: return
    validatePurchaseAmount(amount)
    println()
    val ticketCount = amount / 1000
    println("You have purchased $ticketCount tickets.")
}
