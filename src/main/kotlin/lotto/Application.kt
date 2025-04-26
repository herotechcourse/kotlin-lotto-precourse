package lotto
import camp.nextstep.edu.missionutils.Console
import java.lang.Integer.parseInt

fun main() {
    // prompt user for purchase amount
    println("Please enter the purchase amount.")
    var amountInput = Console.readLine().toInt()
    var amount = parseAmount(amountInput)
    println(amount)
}

fun parseAmount(input: Int): Int {
    // return input if amount if divisible by 1,000
    if (input % 1000 != 0) {
        throw IllegalArgumentException("The amount must be divisible by 1,000.")
    }
    return input
}