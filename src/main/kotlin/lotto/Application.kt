package lotto

fun main() {
    // TODO: Implement the program
    println("Please enter the purchase amount.")
    val amount = readLine()!!.toInt()
    InputValidator.validatePurchaseAmount(amount)
    val ticketCount = amount / 1000
}
