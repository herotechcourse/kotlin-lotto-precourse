package lotto

fun main() {
    println("Please enter the amount you want to spend:")
    val amount = readlnOrNull()?.toIntOrNull()

    if (amount == null || amount < 1000) {
        println("Invalid amount. Please enter a valid number greater than or equal to 1000.")
        return
    }

    println("You entered : $amount")
}
