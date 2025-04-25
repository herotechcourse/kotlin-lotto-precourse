package views

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readLineFromConsole(): String? {
        return Console.readLine()
    }

    fun printError(e: Exception) {
        println("[ERROR] ${e.message}.")
    }

    fun getPurchaseAmount():Int {
        try {
            println()
            println("Please Enter Purchase amount for lottery tickets:")
            val input=readLineFromConsole()
            val purchaseAmount = input?.toIntOrNull() ?: throw IllegalArgumentException("Invalid Purchase Amount Number")
            if (purchaseAmount >= 0 && purchaseAmount % 1000 == 0) {
                return purchaseAmount
            }
            throw IllegalArgumentException("Purchase Amount must be positive and dividable per 1000")
        } catch (e: Exception) {
            printError(e)
            return 0
        }
    }

    fun getWinningNumbers(): List<Int>
    {
        try {
            println()
            println("Please enter last week's winning numbers:")
            val input=readLineFromConsole() ?: ""
            val winningNumbers=input.split(',').map({ it.trim().toInt() })
            if(winningNumbers.size < 6)
                throw IllegalArgumentException("There must be exactly 6 numbers")
            if(winningNumbers.distinct().size < 6)
                throw IllegalArgumentException("There must not be repeated numbers")
            if(!winningNumbers.all { it in 1..45 })
                throw IllegalArgumentException("Each number must be between 1 and 45")
            return winningNumbers
        } catch (e: Exception) {
            printError(e)
            return emptyList()
        }
    }
    
    fun getBonusNumber(): Int
    {
        try {
            println()
            println("Please enter the bonus number.")
            val input=readLineFromConsole()
            val bonusNumber = input?.toIntOrNull() ?: throw IllegalArgumentException("Invalid Bonus Number")
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw IllegalArgumentException("Bonus number must be between 1 and 45")
            }
            return bonusNumber
        } catch (e: Exception) {
            printError(e)
            return 0
        }
    }
}

