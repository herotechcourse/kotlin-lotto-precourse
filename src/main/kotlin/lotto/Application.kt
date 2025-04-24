package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Please enter the purchase amount.")
    val sumOfMoney = Console.readLine()?.toIntOrNull()
        ?: throw IllegalArgumentException("The purchase amount should be an integer.")
    val numberOfTickets = getNumberOfTickets(sumOfMoney)
    validateSumOfMoney(sumOfMoney)
    println("You have purchased $numberOfTickets tickets.")
    repeat(numberOfTickets){
        println(createLotteryTicket())
    }

}

fun getNumberOfTickets(sum: Int): Int {
    return sum / 1000
}

fun validateSumOfMoney(sum: Int) {
    if (sum < 1000) {
        throw IllegalArgumentException("The amount must be divisible by 1,000")
    }

}

fun createLotteryTicket(): List<Int> {
        val generatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return generatedNumbers.sorted()
    }