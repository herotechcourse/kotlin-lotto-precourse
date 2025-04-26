package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(InputView.inputPurchaseAmount())
    println(InputView.inputLottoNumber())
    println(InputView.inputBonusNumber())
}

object InputView {
    fun inputPurchaseAmount():Int {
        println("Please enter the purchase amount.")
        val purchaseAmount = Console.readLine().toInt()
        return purchaseAmount
    }

    fun inputLottoNumber():List<Int> {
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine().removeWhiteSpaces().split(",").map { it.toInt() }
        return winningNumbers
    }

    private fun String.removeWhiteSpaces() = replace("\\s".toRegex(), "")

    fun inputBonusNumber():Int {
        println("Please enter the bonus number.")
        val bonusNumber = Console.readLine().toInt()
        return bonusNumber
    }
}