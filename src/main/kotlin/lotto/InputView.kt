package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    val outputView = OutputView()
    var userPurchase = ""
    var errorType = ""

    fun run(): ArrayList<List<Int>> {
        return readPurchase()
    }

    fun readPurchase(): ArrayList<List<Int>> {
        while (true) {
            println(QUEST_PURCHASE)
            try {
                return outputView.generateTickets(validatePurchase())
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun validatePurchase(): String {
        userPurchase = Console.readLine()
        if (checkPurchase(userPurchase).isNotBlank()) { //if userPurchase is invalid data -> readPurchase ->
            throw IllegalArgumentException(errorMessage(errorType).toString())
        }
        return userPurchase
    }


    fun getPurchase(): String {
        return this.userPurchase
    }

    fun bonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println(QUEST_BONUS_NUM)
            try {
                return validBonusNum(winningNumbers)
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun validBonusNum(winningNumbers: List<Int>): Int {
        val bonusNum = Console.readLine()
        if (checkInRange(bonusNum).isNotBlank() || isSingleBonus(bonusNum).isNotBlank()) {
            throw IllegalArgumentException(errorMessage(errorType).toString())
        }
        duplicateBonusNum(bonusNum, winningNumbers)
        return bonusNum.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            println(QUEST_WINNING_NUM)
            try {
                return generateWinNum(validWinningNum())
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun validWinningNum(): String {
        val winNumber = Console.readLine()
        if (checkWinNum(winNumber).isNotBlank()) {
            throw IllegalArgumentException(errorMessage(errorType).toString())
        }
        return winNumber
    }


    fun generateWinNum(input: String): List<Int> {
        val winList = listOf(*input.split(',').map { it.toInt() }.toTypedArray())
        return winList
    }


    private fun isNumeric(purchase: String): Boolean {
        return try {
            purchase.toInt()
            true
        } catch (e: NotImplementedError) {
            false
        }
    }

    fun checkPurchase(purchase: String): String {
        return errorPurchase(purchase)
    }


    fun errorPurchase(purchase: String): String {
        if (convertNum(purchase).isNotBlank())
            return errorType

        if (purchase.toInt() % 1000 != 0 || purchase.toInt() == 0) {
            errorType = ERROR_MESSAGE_DIV
            return ERROR_MESSAGE_DIV
        }
        return ""
    }

    fun checkWinNum(winNumbers: String): String {
        return errorWinNum(winNumbers)
    }

    fun errorWinNum(winNumbers: String): String {
        if (checkWinFormat(winNumbers).isNotBlank() || checkWinType(winNumbers).isNotBlank()
            || checkWinNumeric(winNumbers).isNotBlank() || checkListInRange(winNumbers).isNotBlank()
        )
            return errorType
        return ""
    }

    fun checkWinFormat(input: String): String {
        if (input.lastOrNull() == ',') {
            errorType = ERROR_MESSAGE_CONFUSE
            return errorType
        }
        return ""
    }

    fun checkWinType(input: String): String {
        if (containCommas(input).isNotBlank()) {
            return errorType
        }
        if (hasDuplicate(listOf(*input.split(',').toTypedArray())).isNotBlank()) {
            return errorType
        }
        return ""
    }

    fun containCommas(input: String): String { //check input contains commas
        if (!input.contains(",")) {
            errorType = ERROR_MESSAGE_COMMA
            return ERROR_MESSAGE_COMMA
        }
        return ""
    }

    fun hasDuplicate(data: List<String>): String {
        if (data.size != data.distinct().count()) {
            errorType = ERROR_MESSAGE_DUPL
            return ERROR_MESSAGE_DUPL
        } else return ""
    }

    fun checkWinNumeric(input: String): String {
        val data = listOf(*input.split(',').toTypedArray())
        data.forEach {
            if (!isNumeric(it)) {
                errorType = ERROR_MESSAGE_WINNUM
                return errorType
            }
        }
        return ""
    }

    fun checkInRange(num: String): String {
        if (convertNum(num).isNotBlank())
            return errorType
        if (numInRange(num).isNotBlank())
            return errorType
        return ""
    }

    fun convertNum(num: String): String {
        if (num.toDoubleOrNull() == null || !isNumeric(num)) {
            errorType = ERROR_SINGLE
            return ERROR_SINGLE
        }
        return ""
    }

    fun numInRange(num: String): String {
        if (num.toInt() < 1 || num.toInt() > 45) {
            errorType = ERROR_MESSAGE_RANGE
            return ERROR_MESSAGE_RANGE
        }
        return ""
    }


    fun checkListInRange(num: String): String {
        val num = listOf(*num.split(',').map { it.toInt() }.toTypedArray())
        num.forEach {
            if (it < 1 || it > 45) {
                errorType = ERROR_MESSAGE_RANGE
                return errorType
            }
        }
        return ""
    }

    fun duplicateBonusNum(bonus: String, winningNumbers: List<Int>) {
        if (winningNumbers.contains(bonus.toInt())) {
            errorType = ERROR_MESSAGE_DUP_BONUS
            throw IllegalArgumentException(errorMessage(errorType).toString())
        }
    }

    fun isSingleBonus(bonus: String): String {
        if (!isNumeric(bonus)) {
            errorType = ERROR_SINGLE
            return errorType
        }
        return ""
    }

    fun errorMessage(error: String) {
        val message = "[ERROR] " + error
        println(message)
    }

    companion object {
        const val QUEST_PURCHASE = "Please enter the purchase amount."
        const val QUEST_WINNING_NUM = "Please enter last week's winning numbers."
        const val QUEST_BONUS_NUM = "Please enter the bonus number."

        const val ERROR_MESSAGE_DIV = "Purchase amount should be divisible by 1000"
        const val ERROR_MESSAGE_RANGE = "Number should be 1 to 45"
        const val ERROR_MESSAGE_COMMA = "Numbers should be separated by commas"
        const val ERROR_MESSAGE_DUPL = "Winning numbers should be unique numbers"
        const val ERROR_MESSAGE_WINNUM = "Winning numbers should be numbers"

        const val ERROR_MESSAGE_DUP_BONUS = "Bonus number is already in winning numbers"
        const val ERROR_MESSAGE_CONFUSE = "Unsupported format"
        const val ERROR_SINGLE = "Enter only one number"
    }
}