package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun InputPurchaseAmount() : String{
        val amount = Console.readLine()
        return amount
    }

    fun InputWinningNumbers() : String{
        val winning_numbers = Console.readLine()
        return winning_numbers
    }

    fun InputBonusNumber(): String{
        val bonus_number = Console.readLine()
        return bonus_number
    }
}