package lotto.io

class InputView(private val io: IOInterface) {

    fun readPurchaseAmount(): Int {
        return retryInput {
            io.print("Please enter the purchase amount.")
            val input = io.read()
            val amount = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

            if (amount <= 0) {
                throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
            }

            if (amount % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1000.")
            }
            amount
        }
    }

    fun readWinningNumbers(): List<Int> {
        return retryInput {
            io.print("Please enter last week's winning numbers.")
            val input = io.read()
            val numbers = input.split(",").map { it.trim().toInt() }
            if (numbers.size != 6) {
                throw IllegalArgumentException("[ERROR] Please enter exactly 6 numbers.")
            }
            if (numbers.distinct().size != 6) {
                throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
            }
            if (numbers.any { it < 1 || it > 45 }) {
                throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
            }
            numbers
        }
    }

    fun readBonusNumber(): Int {
        return retryInput {
            io.print("Please enter the bonus number.")
            val input = io.read()
            val number = input.toInt()
            if (number < 1 || number > 45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            number
        }
    }

    private fun <T> retryInput(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                io.print(e.message ?: "[ERROR] Invalid input.")
            }
        }
    }
}
