package lotto.view

object InputView {

    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."
    private const val INPUT_LAST_WINNING_NUMBER_MESSAGE = "Please enter last week's winning numbers."
    private const val INPUT_LAST_BONUS_NUMBER_MESSAGE = "Please enter the bonus number."

    fun readPurchaseAmount(): String {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return readln()
    }

    fun readLastWinningNumber(): String {
        println(INPUT_LAST_WINNING_NUMBER_MESSAGE)
        return readln()
    }

    fun readLastBonusNumber(): String {
        println(INPUT_LAST_WINNING_NUMBER_MESSAGE)
        return readln()
    }

}
