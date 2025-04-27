package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readPurchase(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val amountMoney = Console.readLine().toIntOrNull()
            try {
                if ((amountMoney == null) || ((amountMoney % 1000) != 0)) {
                    throw IllegalArgumentException("[ERROR] The amount must be integer and divisible by 1,000")
                }
                return amountMoney/1000
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun promptWinningNumbers(): WinningNumbers {

        val mainNumbers = readMainNumbers()
        val bonusNumber = readBonusNumber(mainNumbers)

        return WinningNumbers(mainNumbers, bonusNumber)
    }

    fun readMainNumbers(): List<Int?> {
        while (true){
            println("Please enter last week's winning numbers (commas separated).")
            val mainNumbers = Console.readLine().split(",").map { it.trim() }.map { it.toIntOrNull() }
            try {
                if ((mainNumbers.size != 6) || (mainNumbers.toSet().size != 6)) {
                    throw IllegalArgumentException("[ERROR] Main numbers must contain exact 6 unique numbers")
                }
                if (mainNumbers.any {it !in 1..45}) {
                    throw IllegalArgumentException("[ERROR] Main number must be in the range 1..45")
                }
                return mainNumbers
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    fun readBonusNumber(listNumber: List<Int?>): Int? {
        while (true) {
            println("Please enter the bonus number.")
            val bonusNumber = Console.readLine().toIntOrNull()
            try {

                if ((bonusNumber !in 1 .. 45) || (listNumber.contains(bonusNumber) )) {
                    throw IllegalArgumentException("[ERROR] Bonus numbers must be in the range 1 .. 45 and different to main numbers")
                }
                return bonusNumber

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}