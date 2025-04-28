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
//            userPurchase = Console.readLine()
            try {
//                userPurchase = validatePurchase()
//                if (checkPurchase(userPurchase).isNotBlank()) { //if userPurchase is invalid data -> readPurchase ->
//                    throw IllegalArgumentException(errorMessage(errorType).toString())
//                }
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
//            val bonusNum = Console.readLine()
            try {
                return validBonusNum(winningNumbers)
//                if (checkInRange(bonusNum).isNotBlank()) {
//                    throw IllegalArgumentException(errorMessage(errorType).toString())
//                }
//                if (winningNumbers.contains(bonusNum.toInt())) {
//                    errorType = ERROR_MESSAGE_DUP_BONUS
//                    throw IllegalArgumentException(errorMessage(errorType).toString())
//                }
//                return bonusNum.toInt()
            } catch (e: IllegalArgumentException) {
                continue
            }
        }

    }

    fun validBonusNum(winningNumbers: List<Int>): Int {
        val bonusNum = Console.readLine()
        if (checkInRange(bonusNum).isNotBlank()) {
            throw IllegalArgumentException(errorMessage(errorType).toString())
        }
        duplicateBonusNum(bonusNum, winningNumbers)
        return bonusNum.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            println(QUEST_WINNING_NUM)
            try {
//                val resWinnum = validWinningNum()
//            val winNumber = Console.readLine()
//            try {
//                if (checkWinType(winNumber).isNotBlank()) {
//                    throw IllegalArgumentException(errorMessage(errorType).toString())
//                }
//                if (checkWinNumeric(winNumber).isNotBlank()) {
//                    throw IllegalArgumentException(errorMessage(errorType).toString())
//                }
//                if (checkListInRange(winNumber).isNotBlank()) {
//                    throw IllegalArgumentException(errorMessage(errorType).toString())
//                }
                return generateWinNum(validWinningNum())
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun validWinningNum(): String {
        val winNumber = Console.readLine()
        if (checkWinNum(winNumber).isNotBlank()){
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
        if (purchase.toDoubleOrNull() == null) {
            errorType=ERROR_MESSAGE
            return ERROR_MESSAGE
        }
        if (purchase.toInt() % 1000 != 0) {
            errorType= ERROR_MESSAGE_DIV
            return ERROR_MESSAGE_DIV
        }
        return ""
    }

    fun checkWinNum(winNumbers: String): String{
        return errorWinNum(winNumbers)
    }
    fun errorWinNum(winNumbers: String): String {
        if (hasSpecialInWinnum(winNumbers).isNotBlank()||checkWinType(winNumbers).isNotBlank()||checkWinNumeric(winNumbers).isNotBlank()||checkListInRange(winNumbers).isNotBlank())
            return errorType
//        if (checkWinNumeric(winNumbers).isNotBlank())
//            return errorType
//        if(checkListInRange(winNumbers).isNotBlank())
//            return errorType
        return ""
    }

    fun hasSpecialInWinnum(input: String): String{
        if(Regex("^[1-45,]+\$").matches(input))
        {
            errorType=ERROR_MESSAGE_CONFUSE
            return errorType
        }
        return  ""
    }
    fun checkWinType(input: String): String {
//        if (!containCommas(input))
//            if (!input.contains(",")) {
//                errorType = ERROR_MESSAGE_COMMA
//                return errorType
//            }
        if(containCommas(input).isNotBlank()) {
            errorType= ERROR_MESSAGE_COMMA
            return errorType
        }
        if (hasDuplicate(listOf(*input.split(',').toTypedArray())).isNotBlank()) {
          errorType = ERROR_MESSAGE_DUPL
            return errorType
        }
        return ""
    }

    fun containCommas(input: String): String { //check input contains commas
        if (!input.contains(",")) {
            return ERROR_MESSAGE_COMMA
        }
        return ""
    }

    fun hasDuplicate(data: List<String>): String {
        if (data.size != data.distinct().count())
            return ERROR_MESSAGE_DUPL
        else return ""
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
        if (num.toDoubleOrNull() == null || num.toInt() < 1 || num.toInt() > 45) {
            return errorRange(num)
        }
//        if (num.toDoubleOrNull() == null) {
//            errorType = ERROR_MESSAGE
//            return errorType
//        }
//        if (num.toInt() < 1 || num.toInt() > 45) {
//            errorType = ERROR_MESSAGE_RANGE
//            return errorType
//        }
        return ""
    }

    fun errorRange(num: String): String {
        if (num.toDoubleOrNull() == null) {
            return ERROR_MESSAGE
        }
        if (num.toInt() < 1 || num.toInt() > 45) {
            return ERROR_MESSAGE_RANGE
        }
        return ""
    }

    fun checkListInRange(num: String): String {
        val num = listOf(*num.split(',').map { it.toInt() }.toTypedArray())
        num.forEach {
            if (it < 1 || it > 45) {
//                throw IllegalArgumentException(errorMessage(ERROR_MESSAGE_RANGE))
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

    fun errorMessage(error: String) {
        val message = "[ERROR] " + error
        println(message)
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

        const val ERROR_MESSAGE_DUP_BONUS = "Bonus number is already in winning numbers"
        const val ERROR_MESSAGE_CONFUSE = "Unsupported format"
    }
}