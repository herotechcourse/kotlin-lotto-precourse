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