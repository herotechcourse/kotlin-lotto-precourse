package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // prompt user for purchase amount
    println("Please enter the purchase amount.")
    val amountInput = Console.readLine().toInt()
    val tickets = parseAmount(amountInput)
    println("\nYou have purchased $tickets tickets.")
    // parse tickets to generate numbers
    val lottoNumbers = generateLotto(tickets)
    for (numbers in lottoNumbers) {
        println(numbers)
    }

    // prompt user for last week's winning numbers
    println("\nPlease enter last week's winning numbers.")
    val winningNumbers = mutableListOf<Int>()
    val winningInput = Console.readLine()
    val numbers = winningInput.split(",")
    for (number in numbers) {
        winningNumbers.add(number.toInt())
    }

    // prompt user for the bonus number
    println("\nPlease enter the bonus number.")
    val bonusNumber = Console.readLine().toInt()
}

fun parseAmount(input: Int): Int {
    // return input if amount if divisible by 1,000
    if (input % 1000 != 0) {
        throw IllegalArgumentException("The amount must be divisible by 1,000.")
    }
    return input/1000
}

fun generateLotto(tickets: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    repeat(tickets) {
        result.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
    return result
}