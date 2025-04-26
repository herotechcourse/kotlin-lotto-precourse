package lotto

object InputValidate {

    fun validateAmount(input: String?): Int {
        val amount = try {
            input!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Input purchaseAmount must be integer")
        }
        if (amount <= 0)
            throw IllegalArgumentException("[ERROR] Input purchaseAmount must be positive integer")
        if (amount % 1000 != 0)
            throw IllegalArgumentException("[ERROR] Input purchaseAmount must be divided by 1000")

        return amount
    }

    fun validateWinningNumber(input: String?): List<Int> {

        val inputList: List<String> = input!!.split(",")
            .map { it.trim() }.map { it.replace("\\s+".toRegex(), "") }

        val safeIntList: List<Int> = inputList.mapNotNull { it.toIntOrNull()?:
                throw IllegalArgumentException("[ERROR] Input must be integer") }
        if (safeIntList.size != 6 || safeIntList.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers format is not correct.")
        }
        if (safeIntList.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
        return safeIntList
    }

    fun validateBonusNumber(input: String?, winningNumber: List<Int>): Int {
        val bonus = input!!.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be integer")

        if (bonus !in 1..45)
            throw IllegalArgumentException("[ERROR] Bonus number must between 1 to 45")

        if (winningNumber.contains(bonus))
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")

        return bonus
    }

    fun validateTickets(tickets: MutableList<MutableList<Int>>): List<List<Int>> {
       if(tickets.isEmpty())
           throw IllegalArgumentException("[ERROR] Tickets are empty" )

        return tickets
    }

}



