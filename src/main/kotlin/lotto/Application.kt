package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // prompt user for purchase amount
    println("Please enter the purchase amount.")
    val amountInput = Console.readLine().toInt()
    val tickets = parseAmount(amountInput)
    println("you have purchased $tickets tickets.")
    // parse tickets to generate numbers
    val lottoNumbers = generateLotto(tickets)
    for (numbers in lottoNumbers) {
        println(numbers)
    }
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