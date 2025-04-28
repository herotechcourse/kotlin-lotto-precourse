package lotto

import camp.nextstep.edu.missionutils.Console

class TakeWinningNumbers(
    private val testWinningNumbersProvider: (() -> String)? = null,
    private val testBonusNumberProvider: (() -> String)? = null
) {

    fun inputSixNumbersAndBonus(): MutableList<Int> {
        val winningList = inputWinningNumbers()
        winningList.add(inputBonusNumber(winningList))
        return winningList
    }

    private fun checkIndividualNumber(individualNumber: String): Int {
        val numericVersion = individualNumber.toInt()
        if (numericVersion < 1 || numericVersion > 45)
            throw IllegalArgumentException("[ERROR] Every winning number must be from 1 to 45.")
        return numericVersion
    }

    private fun thereAreDuplicateWinnerNums(finalWinnerList: MutableList<Int>): Boolean {
        for (number in finalWinnerList) {
            if (finalWinnerList.count { it == number } > 1)
                return true
        }
        return false
    }

    private fun checkAndAdjustWinningNums(splitInput: List<String>): MutableList<Int> {
        val finalWinnerList = mutableListOf<Int>()
        if (splitInput.size != 6)
            throw IllegalArgumentException("[ERROR] There must be 6 winning numbers.")
        for (individualNumber in splitInput)
            finalWinnerList.add(checkIndividualNumber(individualNumber))
        if (thereAreDuplicateWinnerNums(finalWinnerList))
            throw IllegalArgumentException("[ERROR] Every winning number must be unique.")
        return finalWinnerList
    }

    private fun takeInputSixNumbers(): MutableList<Int> {
        println("\nPlease enter last week's winning numbers.")
        val splitInput = (testWinningNumbersProvider?.invoke() ?: Console.readLine()).split(',')
        try {
            return checkAndAdjustWinningNums(splitInput)
        } catch (_: NumberFormatException) {
            println("[ERROR] Input must be fully numeric with the exception of separating commas.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return mutableListOf()
    }

    private fun inputWinningNumbers(): MutableList<Int> {
        var winningList = mutableListOf<Int>()
        while (winningList.size < 6) {
            winningList = takeInputSixNumbers()
        }
        return winningList
    }

    private fun validateBonusNum(input: Int, winningList: MutableList<Int>): Int {
        if (input < 1 || input > 45)
            throw IllegalArgumentException("[ERROR] The bonus number must be from 1 to 45.")
        if (winningList.count { it == input } > 0)
            throw IllegalArgumentException("[ERROR] The bonus number can't be the same as any of the winning numbers.")
        return input
    }

    private fun takingAndCheckingBonusNumber(input: String, winningList: MutableList<Int>): Int {
        try {
            return validateBonusNum(input.toInt(), winningList)
        } catch (_: NumberFormatException) {
            println("[ERROR] Input must be fully numeric.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        return 0
    }

    private fun inputBonusNumber(winningList: MutableList<Int>): Int {
        var bonusNum = 0
        while (bonusNum == 0) {
            println("\nPlease enter the bonus number.")
            bonusNum = takingAndCheckingBonusNumber(testBonusNumberProvider?.invoke() ?: Console.readLine(), winningList)
            if (bonusNum in 1..45)
                return bonusNum
        }
        return 0
    }
}
