package lotto

const val PURCHASE_AMOUNT_TEXT = "Please enter the purchase amount."
const val WINNING_NUMBERS_TEXT = "Please enter last week's winning numbers."
const val BONUS_NUMBER_TEXT = "Please enter the bonus amount."

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoProcessor = LottoProcessor()

    while (true) {
        try {
            val purchaseAmount = InputView.getPurchaseAmount(inputView.inputReader(PURCHASE_AMOUNT_TEXT))
            val tickets = lottoProcessor.ticketGenerator(purchaseAmount)
            outputView.displayTickets(tickets)

            val winningNumbers = InputView.getWinningNumbers(inputView.inputReader(WINNING_NUMBERS_TEXT))
            val bonusNumber = InputView.getBonusNumber(inputView.inputReader(BONUS_NUMBER_TEXT))

            val prizes = lottoProcessor.prizeCalculator(tickets, winningNumbers, bonusNumber)
            val profitRate = lottoProcessor.profitRateCalculator(purchaseAmount, prizes)

            outputView.displayStatistics(prizes)
            outputView.displayProfitRate(profitRate)
            break
        } catch (e: IllegalArgumentException) {
            println("${e.message}\nTry again\n" )
        }
    }
}
