package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        println("Please enter the purchase amount.")
        val amount = totalPurchaseAmount()

        val ticketAmount = List(amount / 1000) { generateLotto() }
        println("You have purchased ${ticketAmount.size} tickets.")
        ticketAmount.forEach { println(it.getNumbers()) }

        println("Please enter last week's winning numbers.")
        val winningNumbers = getWinningNumbers()

        println("Please enter the bonus number.")
        val bonusNumber = getBonusNumber(winningNumbers)

        val prize = WinningNumbers(winningNumbers, bonusNumber)
        val results = ticketAmount.map { prize.match(it) }
        printResult(results, totalPurchaseAmount = ticketAmount.size * 1000)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}


// get user Input
fun totalPurchaseAmount(): Int{
    val inputMoney = Console.readLine()
    val amount = inputMoney.toIntOrNull()
    if (amount == null) {
        throw IllegalArgumentException("[ERROR] Input must be a number")
    }
    if (amount <= 0 || amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Input amount must be divisible by 1000")
    }
    return amount
}

//get winning numbers
fun getWinningNumbers() : List<Int> {
    val inputNumbers = Console.readLine()
    val numbers = inputNumbers.split(",").map { it.trim().toIntOrNull() }
    if (numbers.any { it == null }) {
        throw IllegalArgumentException("[ERROR] Input must be a number")
    }
    val finalNumbers = numbers.filterNotNull()
    if (finalNumbers.toSet().size != 6 || finalNumbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] Numbers must be 6 unique numbers between 1 and 45")
    }
    return finalNumbers
}

//get bonus numbers
fun getBonusNumber ( winningNumbers: List<Int>): Int  {
    val input = Console.readLine()
    val bonus = input.toIntOrNull()
    if (bonus == null) {
        throw IllegalArgumentException("[ERROR] Input must be a number")
    }
    if (bonus !in 1..45 || winningNumbers.contains(bonus)) {
        throw IllegalArgumentException("[ERROR] Bonus number must be a separate number between 1 and 45")
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