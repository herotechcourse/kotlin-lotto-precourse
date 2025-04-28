package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    val amount = totalPurchaseAmount()
    val ticketAmount = List(amount / 1000){generateLotto()}
    println("You have purchased ${ticketAmount.size} tickets.")
    ticketAmount.forEach { println(it.getNumbers()) }
    val winningNumbers = getWinningNumbers()
    val bonusNumber = getBonusNumber(winningNumbers)

    val prize = WinningNumbers(winningNumbers, bonusNumber)
    val results = ticketAmount.map { prize.match(it) }
    printResult(results, totalPurchaseAmount = ticketAmount.size * 1000)
    
}
// get user Input
fun totalPurchaseAmount(): Int{
    println("Please enter the purchase amount.")
    val inputMoney = Console.readLine()
    val amount = inputMoney.toIntOrNull()
    if (amount == null) {
        val errorMessage = "[ERROR] Input must be a number"
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
    if (amount <= 0 || amount % 1000 != 0) {
        val errorMessage = "[ERROR] Input amount must be divisible by 1000"
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
    return amount
}

//get winning numbers
fun getWinningNumbers() : List<Int> {
    println("Please enter last week's winning numbers.")
    val inputNumbers = Console.readLine()
    val numbers = inputNumbers.split(",").map { it.trim().toIntOrNull() }
    if (numbers.any { it == null }) {
        val errorMessage = "[ERROR] Input must be a number"
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
    val finalNumbers = numbers.filterNotNull()
    if (finalNumbers.toSet().size != 6 || finalNumbers.any { it !in 1..45 }) {
        val errorMessage = "[ERROR] Numbers must be 6 unique numbers between 1 and 45"
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
    return finalNumbers
}

//get bonus numbers
fun getBonusNumber ( winningNumbers: List<Int>): Int  {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val bonus = input.toIntOrNull()
    if (bonus == null) {
        val errorMessage = "[ERROR] Input must be a number"
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
    if (bonus !in 1..45 || winningNumbers.contains(bonus)) {
        val errorMessage = "[ERROR] Bonus number must be a separate number between 1 and 45"
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
    return bonus
}

//print result format
fun resultFormat(prize: Prize): String {
    return when (prize) {
        Prize.FIFTH -> "3 Matches (5,000 KRW)"
        Prize.FOURTH -> "4 Matches (50,000 KRW)"
        Prize.THIRD -> "5 Matches (1,500,000 KRW)"
        Prize.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
        Prize.FIRST -> "6 Matches (2,000,000,000 KRW)"
        else -> ""
    }
}

//print result
fun printResult(result: List<Prize>, totalPurchaseAmount: Int){
    println("Winning Statistics")
    println("---")

    Prize.values().filter { it!= Prize.NONE}.forEach { prize ->
    val count = result.count {it == prize}
    println("${resultFormat(prize)} – $count tickets")
    }

    val totalPrize = result.sumOf{it.reward}
    val profitRate = (totalPrize.toDouble() / totalPurchaseAmount) * 100
    println("Total return rate is ${"%.1f".format(profitRate)}%.")
}