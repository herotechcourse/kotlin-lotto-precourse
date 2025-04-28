package lotto

object OutputView {

    const val ASK_FOR_PURCHASE_AMOUNT = "Please enter the purchase amount."
    const val ASK_FOR_WINNING_NUMBERS = "Please enter last week's winning numbers."
    const val ASK_FOR_BONUS_NUMBER = "Please enter the bonus number."

    fun askForPurchaseAmount() {
        println(ASK_FOR_PURCHASE_AMOUNT)
    }

    fun askForWinningNumbers() {
        println(ASK_FOR_WINNING_NUMBERS)
    }

    fun askForBonusNumber() {
        println(ASK_FOR_BONUS_NUMBER)
    }
}