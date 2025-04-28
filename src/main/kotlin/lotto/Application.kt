package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {

    val amount = totalPurchaseAmount()
    val ticketAmount = List(amount / 1000){generateLotto()}
    println("You have purchased ${ticketAmount.size} tickets.")
    ticketAmount.forEach { println(it.getNumbers()) }
    val winningNumbers = getWinningNumbers()
    val bonusNumber = getBonusNumber()

    val prize = WinningNumbers(winningNumbers, bonusNumber)
    val results = tickets.map { winningNumbers.match(it) }
    printResults(results, purchaseAmount = tickets.size * 1000)
    
}
// get user Input
fun totalPurchaseAmount(): Int{
    println("Please enter the purchase amount.")
    val inputMoney = Console.readLine()
    val amount = inputMoney.toIntOrNull() ?: throw IllegalArgumentException("[ERROR]Input must be a number")
    if(amount <= 0 || amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR]input amount has to be divisible by 1000")
    }
    return amount;
}

//get winning numbers
fun getWinningNumbers() : List<Int> {
    println("[ERROR]Please enter last week's winning numbers.")
    val inputNumbers = Console.readLine()
    val numbers = inputNumbers.split(",").map {it.trim().toIntOrNull() ? throw IllegalArgumentException("[ERROR]Input must be a number") }
    if(numbers.toSet().size != 6 || numbers.any{it !in 1..45}){
        throw IllegalArgumentException("[ERROR]Numbers must be 6 unique numbers between 1 and 45.")
    }
    return numbers
}
//get bonus numbers
fun getBonusNumber() ( winningNumbers: List<Int>): Int  {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val bonus = input.toIntOrNull()?: throw IllegalArgumentException("[ERROR]Input must be a number")
    if(bonus !in 1..45 || winningNumbers.contains(bonus)){
        throw IllegalArgumentException("[ERROR] Bonus number must be a seperate number between 1 and 45")
    }
    return bonus
}

//print result format
fum resultFormat(prize: Prize): String {
    retur when (prize) {
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