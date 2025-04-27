package lotto

const val PURCHASE_AMOUNT_TEXT = "Please enter the purchase amount."
const val WINNING_NUMBERS_TEXT = "Please enter last week's winning numbers."
const val BONUS_NUMBER_TEXT = "Please enter the bonus amount."

fun main() {
    val lottoProcessor = LottoProcessor()

    while (true) {
        try {
            lottoProcessor.processLotto(InputView.getPurchaseAmount(InputView.inputReader(PURCHASE_AMOUNT_TEXT)))
            break
        } catch (e: IllegalArgumentException) {
            println("${e.message}\nTry again\n" )
        }
    }
}
