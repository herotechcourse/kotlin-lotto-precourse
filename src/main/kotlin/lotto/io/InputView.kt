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
            validateNumbers(numbers)
            numbers
        }
    }

    fun readBonusNumber(): Int {
        return retryInput {
            io.print("Please enter the bonus number.")
            val input = io.read()
            val number = input.toInt()
            validateNumber(number)
            number
        }
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.size != 6 || numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers.")
        }
        numbers.forEach { validateNumber(it) }
    }

    private fun validateNumber(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
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
