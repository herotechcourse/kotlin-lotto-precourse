package lotto

import camp.nextstep.edu.missionutils.Console


object InputView {
    fun readPurchaseAmount(): Int {
        return Console.readLine().toInt()
    }


    fun raedWinnerNumbers(): List<Int> {
        val winnerNumbers = Console.readLine()
            .split(",")
            .map { it.trim().toInt() }

        return winnerNumbers
    }


    fun readBonusNumber(): Int {
        return Console.readLine().toInt()
    }
}