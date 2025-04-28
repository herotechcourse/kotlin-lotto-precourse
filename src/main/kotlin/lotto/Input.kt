package lotto

object Input {

    fun purchasePrice(): Int {
        println("Please enter the purchase amount.")
        val input = readLine()
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
        val price = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number divisible by 1000.")
        if (price % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        }
        return price
    }

    fun correctNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's winning numbers.")
            try {
                val input = readLine()!!.trim()
                val numbers = input.split(",").map { it.toInt() }
                validateLottoNumbers(numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("Please enter the bonus number.")
            try {
                val input = readLine()!!.trim()
                val number = input.toInt()
                validateBonusNumber(number, winningNumbers)
                return number
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    private fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
        require(number in 1..45) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(number !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
    }
}
