package lotto
import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    val amount = readPuchaseAmount()
    println("Purchase amount = $amount")
}
fun readPuchaseAmount(): Int {
    println("Enter the Purchase Amount:")
    val input = Console.readLine()
    val amount = input.toIntOrNull()
        ?: throw IllegalArgumentException("[Error] Input must be a valid integer.")

    if (amount <= 0 || amount % 100 != 0) {
        throw IllegalArgumentException("[Error] Amount must be a positive number divisible by 1000")
    }
    return amount
}