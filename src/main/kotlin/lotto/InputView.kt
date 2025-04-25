package lotto

object InputView {
    fun readPurchaseAmount(): Int {
        println("Enter purchase amount:")
        val input = readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input required")
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Not a valid number")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Must be divisible by 1000")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Enter winning numbers (comma-separated):")
        val input = readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input required")
        val numbers = input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Not a number")
        }
        if (numbers.size != 6 || numbers.toSet().size != 6 || numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Must be 6 unique numbers between 1 and 45")
        }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("Enter bonus number:")
        val bonus = readLine()?.trim()?.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Not a valid number")
        if (bonus !in 1..45) throw IllegalArgumentException("[ERROR] Number must be between 1 and 45")
        return bonus
    }
}
