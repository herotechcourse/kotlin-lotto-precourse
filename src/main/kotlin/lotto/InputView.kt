package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readPurchase(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val amountMoney = Console.readLine()!!.toIntOrNull()
            try {
                if ((amountMoney == null) || ((amountMoney % 1000) != 0)) {
                    throw IllegalArgumentException("[ERROR] The amount must be divisible by 1,000")
                }
                return amountMoney/1000
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }

    }

    fun promptWinningNumber(): WinningNumbers {
        println("Please enter last week's winning numbers (commas separated).")
        val winningNumbers = Console.readLine()!!.split(",").map { it.trim() }.map { it.toIntOrNull() }

        println("Please enter the bonus number.")
        val bonusNumber = Console.readLine()!!.toIntOrNull()

        return WinningNumbers(winningNumbers, bonusNumber)
    }

    fun readWinningNumber(): List<Int?> {

        println("Please enter last week's winning numbers (commas separated).")
        val winningNumbers = Console.readLine()!!.split(",").map { it.trim() }.map { it.toIntOrNull() }

        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] List must contain exact 6 numbers")
        }

        if (winningNumbers.any{ !checkLottoNumber(it) }) {
            throw IllegalArgumentException("[Error] Each number must be integer in the range [1,45]")
        }
        return winningNumbers
    }

    fun readBonusNumber(): Int? {
        println("Please enter the bonus number.")
        val bonusNumber = Console.readLine()!!.toIntOrNull()

        if (!checkLottoNumber(bonusNumber)) {
            throw IllegalArgumentException("[Error] Bonus number must be integer in the range [1,45]")
        }

        return bonusNumber
    }

    fun checkBonusNumber(listNumber: List<Int?>, number: Int?): Boolean {
        return listNumber.contains(number)
    }

    private fun checkLottoNumber(number: Int?): Boolean {
        return ((number != null) && (number >= 1) && (number <=45))
    }



}