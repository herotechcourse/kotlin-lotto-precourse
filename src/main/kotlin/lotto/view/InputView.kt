package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getBudget(): String {
        println("Please enter the purchase amount.")
        val budget = Console.readLine()
        return budget
    }
}