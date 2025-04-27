package lotto

class LottoGame (
    private val inputView: InputView,
    private val lottoValidator: LottoValidator
) {
    private var winningNumbers = emptyList<String>()

    fun start(){
        getNumberOfTickets()
        initWinningNumbers()
    }

    private fun getNumberOfTickets(): Int = repeatUntilSuccess {
        val amount = inputView.readPurchaseAmount()
        lottoValidator.validatePurchaseAmount(amount)
        amount.toInt() / 1000
    }

    private fun initWinningNumbers() = repeatUntilSuccess {
        val input: List<String> = inputView.readWinningNumbers()
        lottoValidator.validateWinningNumbers(input)
        winningNumbers = input
    }

    private fun <T> repeatUntilSuccess(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}