package lotto
import camp.nextstep.edu.missionutils.Console

class Input {

    //1. find number of tickets that can be purchased with the purchase amount entered
    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount: ")
                val input = Console.readLine()?.toIntOrNull()
                    ?: throw IllegalArgumentException("Purchase amount must be a valid number.")

                validatePurchaseAmount(input)

                val tickets = input / DIVISIBLE_AMOUNT
                println("\nYou have purchased $tickets tickets.")
                return tickets
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }catch (e: IllegalStateException) {
                println("[testERROR] ${e.message}")
            }
        }

    }

    private fun validatePurchaseAmount(input: Int) {
        require(input > 0) { "Purchase amount must be greater than zero." }
        require(input % DIVISIBLE_AMOUNT == 0) { "Purchase amount must be divisible by $DIVISIBLE_AMOUNT KRW." }
    }

    //3. Implement a function to get winning number list and bonus number as user input
    fun getWinningNumbers(): MutableList<Int> {
        while (true) {
            println("Please enter last week's winning numbers (comma-separated): ")
            try {
                val numbers = Console.readLine()
                    ?.split(",")
                    ?.map {
                        it.trim().toIntOrNull() ?: throw IllegalArgumentException("All entries must be valid numbers.")
                    }
                    ?: throw IllegalArgumentException("Input cannot be empty.")

                validateWinningNumbers(numbers)

                return numbers.toMutableList()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
        //return (winningNumbers)
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.size == LOTTO_MAX_SIZE) { "You must enter exactly 6 winning numbers." }
        require(numbers.all { it in TICKET_MIN_VALUE..TICKET_MAX_VALUE }) { "Numbers must be between 1 and 45." }
        require(numbers.toSet().size == numbers.size) { "Winning numbers must not contain duplicates." }
    }

    fun getBonus(): Int {


        while (true) {
            println("Please enter the bonus number: ")
            try {
                val bonus = Console.readLine()?.trim()?.toIntOrNull()
                    ?: throw IllegalArgumentException("Bonus must be a valid number.")

                validateBonus(bonus)

                return bonus
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }

    }

    private fun validateBonus(bonus: Int) {
        require(bonus in BONUS_MIN_VALUE..BONUS_MAX_VALUE) { "Bonus number must be between 1 and 45." }
    }

    companion object {
        const val LOTTO_MAX_SIZE = 6
        const val DIVISIBLE_AMOUNT = 1000
        const val RANDOM_MIN_VALUE=1
        const val RANDOM_MAX_VALUE=45
        const val TICKET_MIN_VALUE = 1
        const val TICKET_MAX_VALUE = 45
        const val BONUS_MIN_VALUE = 1
        const val BONUS_MAX_VALUE = 45

    }
}