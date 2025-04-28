package lotto

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount. ")
        val input = camp.nextstep.edu.missionutils.Console.readLine()
        try {
            val amount = input.toInt()
            if (amount < 1000) {
                throw IllegalArgumentException("[ERROR] Minimum purchase amount is 1,000 KRW. ")
            }
            if (amount % 1000 != 0) {
                throw IllegalArgumentException(" [ERROR] Amount must be divisible by 1,000.")
            }
            return amount
        } catch (e: NumberFormatException){
            throw IllegalArgumentException(" [ERROR] Please enter valid number.")
        }
    }

    fun readWinningNumbers(): List<Int>{
        println("Please enter last week's winning numbers.")
        val input = camp.nextstep.edu.missionutils.Console.readLine()
        try {
            val numbers = input.split(",").map { it.trim().toInt() }
            if (numbers.size != 6) {
                throw IllegalArgumentException("[ERROR] You must enter exactly 6 numbers. ")
            }
            if (numbers.any { it < 1 || it > 45 }){
                throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45. ")
            }
            if (numbers.size != numbers.distinct().size){
                throw IllegalArgumentException("[ERROR] Numbers must be unique.")
            }
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid comma-separated numbers. ")
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = camp.nextstep.edu.missionutils.Console.readLine()
        try {
            val bonusNumber = input.toInt()
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }
}