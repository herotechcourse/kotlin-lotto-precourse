package lotto

class LottoGame (
    private val inputView: InputView,
    private val lottoValidator: LottoValidator
) {
    private var winningNumbers = emptyList<Int>()
    private var bonusNumber = 0

    fun start(){
        getNumberOfTickets()
        initWinningNumbers()
        initBonusNumber()
    }

    private fun getNumberOfTickets(): Int = repeatUntilSuccess {
        val amount = inputView.readPurchaseAmount()
        lottoValidator.validatePurchaseAmount(amount)
        amount.toInt() / 1000
    }

    private fun initWinningNumbers() = repeatUntilSuccess {
        val input: List<String> = inputView.readWinningNumbers()
        lottoValidator.validateWinningNumbers(input)
        winningNumbers = input.map { it.toInt() }
    }

    private fun initBonusNumber() = repeatUntilSuccess {
        val input = inputView.readBonusNumber()
        lottoValidator.validateBonusNumber(input, winningNumbers)
        bonusNumber = input.toInt()
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