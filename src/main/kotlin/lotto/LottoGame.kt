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

    private fun getNumberOfTickets(): Int{
        while (true) {
            try {
                val amount = inputView.readPurchaseAmount()
                lottoValidator.validatePurchaseAmount(amount)
                amount.toInt() / 1000
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun initWinningNumbers() {
        while (true) {
            try {
                val input: List<String> = inputView.readWinningNumbers()
                lottoValidator.validateWinningNumbers(input)
                winningNumbers = input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}