package lotto

class Application {
    fun run() {
        // 1. Ask for amount
        print("Enter the amount: ")
        val amount = readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid number input.")
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        }

        val tickets = amount / 1000
        println("You've purchased $tickets tickets for $amount Won\n")

        // Defining 6 winning numbers
        print("Enter six winning numbers (comma-separated): ")
        val input = readLine()
            ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
        val winningNumbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number in winning numbers.") }

        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter exactly 6 numbers.")
        }

        // Defining for bonus number
        print("Enter the bonus number: ")
        val bonusNumber = readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please pick only one bonus number")

        // Print summary
        println("\n--- Lotto Summary ---")
        println("Amount: $amount")
        println("Ticket Amount: $tickets")
        println("Winning Numbers: $winningNumbers")
        println("Bonus Number: $bonusNumber")
    }
}

fun main() {
    Application().run()
    println("/n Lotto machine is spinning...\n")
}
