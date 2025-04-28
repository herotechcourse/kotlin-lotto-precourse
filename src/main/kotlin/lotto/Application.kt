package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    val amount = totalPurchaseAmount()
    val ticketAmount = List(amount / 1000){generateLotto()}
    println("You have purchased ${ticketAmount.size} tickets.")
    ticketAmount.forEach { println(it.getNumbers()) }
    // get user Input
    fun totalPurchaseAmount(): Int{
        println("Please enter the purchase amount.")
        val inputMoney = Console.readLine()
        val amount = inputMoney.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number")
        if(amount <= 0 || amount % 1000 != 0) {
        throw IllegalArgumentException("input amount has to be divisible by 1000")
    }
    return amount;
}
