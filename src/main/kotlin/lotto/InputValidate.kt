package lotto

object InputValidate {

    fun validateAmount(input: String): Int {
        val amount = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] PurchaseAmount must be integer")
        }
        if (amount <= 0 || amount % 1000 != 0)
            throw IllegalArgumentException("[ERROR] PurchaseAmount must be positive integer and divided by 1000")
        return amount
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val inputList = input.split(",").map { it.trim() }
        val safeIntList = inputList.mapNotNull { it.toIntOrNull() ?:
            throw IllegalArgumentException("[ERROR] Input must be integer") }
        if (safeIntList.size != 6 || safeIntList.toSet().size != 6 || safeIntList.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 and from range 1 to 45.")
        }
        return safeIntList
    }

    fun validateBonusNumber(input: String, winningNumber: List<Int>): Int {
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be integer")
        if (bonus !in 1..45)
            throw IllegalArgumentException("[ERROR] Bonus number must between 1 to 45")
        if (winningNumber.contains(bonus))
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")
        return bonus
    }

    fun validateTickets(tickets: MutableList<MutableList<Int>>): List<List<Int>> {
        if (tickets.isEmpty())
            throw IllegalArgumentException("[ERROR] Tickets are empty")
        val safeTickets = tickets.map { it.toList() }
        return safeTickets
    }

}



