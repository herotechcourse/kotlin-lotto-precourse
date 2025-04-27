package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    val outputView = OutputView()
    var userPurchase = ""
    fun run(): ArrayList<List<Int>> {
        return readPurchase()
    }

    fun readPurchase(): ArrayList<List<Int>> {
        println(QUEST_PURCHASE)
        userPurchase = Console.readLine()
        while (checkPurchase(userPurchase)) {
            try {
                break
            } catch (e: IllegalArgumentException) {
                readPurchase()
            }
        }
        return outputView.generateTickets(userPurchase)
    }

    fun getPurchase(): String {
        return this.userPurchase
    }

    fun bonusNumber(): Int {
        println(QUEST_BONUS_NUM)
        val bonusNum = Console.readLine()
        while (checkInRange(bonusNum) && checkBonusNumeric(bonusNum)) {
            try {
                break
            } catch (e: IllegalArgumentException) {
                bonusNumber()
            }
        }
        return bonusNum.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println(QUEST_WINNING_NUM)
        val winNumber = Console.readLine()
        while (checkWinType(winNumber) && checkWinNumeric(winNumber) && checkListInRange(winNumber)) {
            try {
                break
            } catch (e: IllegalArgumentException) {
                readWinningNumbers()
            }
        }
        return generateWinNum(winNumber)
    }

    fun generateWinNum(input: String): List<Int> {
        val winList = listOf(*input.split(',').map { it.toInt() }.toTypedArray())
        return winList
    }


    private fun isNumeric(purchase: String): Boolean {
        return try {
            purchase.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun checkPurchase(purchase: String): Boolean {
        if (!isNumeric(purchase)) {
            throw IllegalArgumentException(errorMessage(ERROR_MESSAGE))
        }
        if (purchase.toInt() % 1000 != 0) {
            throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_DIV))
        }
        return true
    }

    fun checkWinType(input: String): Boolean {
        if (!input.contains(",")) {
            throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_COMMA))
        }
        if (hasDuplicate(listOf(*input.split(',').toTypedArray()))) {
            throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_DUPL))
        }
        return true
    }


    fun hasDuplicate(data: List<String>): Boolean {
        return data.size != data.distinct().count()
    }

    fun checkWinNumeric(input: String): Boolean {
        val data = listOf(*input.split(',').toTypedArray())
        data.forEach {
            if (!isNumeric(it)) {
                throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_WINNUM))
            }
        }
        return true
    }

    fun checkInRange(num: String): Boolean {
        val convert = num.toInt()
        if (convert < 1 || convert > 45) {
            throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_RANGE))
        }
        return true
    }

    fun checkListInRange(num: String): Boolean {
        val num = listOf(*num.split(',').map { it.toInt() }.toTypedArray())
        num.forEach {
            if (it < 1 || it > 45) {
                throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_RANGE))
            }
        }
        return true
    }

    fun checkBonusNumeric(num: String): Boolean {
        if (!isNumeric(num)) {
            throw IllegalArgumentException(errorMessage(ERROR_MESSAGE))
        }
        return true
    }

    fun errorMessage(error: String): String {
        val message = "[ERROR] $error"
        return message
    }

    companion object {
        const val QUEST_PURCHASE = "Please enter the purchase amount."
        const val QUEST_WINNING_NUM = "Please enter last week's winning numbers."
        const val QUEST_BONUS_NUM = "Please enter the bonus number."

        const val ERROR_MESSAGE = "Input should number"
        const val ERROR_MESSAGE_DIV = "Purchase amount should be divisible by 1000"
        const val ERROR_MESSAGE_RANGE = "Number should be 1 to 45"
        const val ERROR_MESSAGE_COMMA = "Numbers should be separated by commas"
        const val ERROR_MESSAGE_DUPL = "Winning numbers should be unique numbers"
        const val ERROR_MESSAGE_WINNUM = "Winning numbers should be numbers"

    }
}