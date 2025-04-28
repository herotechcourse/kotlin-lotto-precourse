package lotto.view
import camp.nextstep.edu.missionutils.Console

class InputView{

    fun readPurchaseAmount(): String {
        println(GET_PURCHASE_AMOUNT)
        return Console.readLine().trim()
    }

    fun readWinningNumbers(): String {
        println(GET_WINNING_NUMBERS)
        return Console.readLine().trim()
    }

    fun readBonusNumber(): String {
        println(GET_BONUS_NUMBER)
        return Console.readLine().trim()
    }

    companion object {
        private const val GET_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val GET_WINNING_NUMBERS = "\nPlease enter last week's winning numbers (separated by commas)."
        private const val GET_BONUS_NUMBER = "\nPlease enter the bonus number."
    }

}