package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame (
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoValidator: LottoValidator
) {
    private lateinit var winningCombination: WinningCombination

    fun start(){
        val numberOfTickets = getNumberOfTickets()

        val lottoList = generateLottoTickets(numberOfTickets)
        displayPurchasedTickets(lottoList)

        initWinningNumbers()
        initBonusNumber()
    }

    private fun getNumberOfTickets(): Int = repeatUntilSuccess {
        val amount = inputView.readPurchaseAmount()
        lottoValidator.validatePurchaseAmount(amount)
        amount.toInt() / 1000
    }

    private fun generateLottoTickets(numberOfTickets: Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat (numberOfTickets) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottoTickets.add(lotto)
        }
        return lottoTickets
    }

    private fun displayPurchasedTickets(lottoTickets: List<Lotto>) {
        outputView.displayPurchasedTickets(lottoTickets)
    }

    private fun initWinningNumbers() = repeatUntilSuccess {
        val input: List<String> = inputView.readWinningNumbers()
        lottoValidator.validateWinningNumbers(input)
        winningCombination = WinningCombination(input.map { it.toInt() }, 0)
    }

    private fun initBonusNumber() = repeatUntilSuccess {
        val input = inputView.readBonusNumber()
        lottoValidator.validateBonusNumber(input, winningCombination.winningNumberList)
        winningCombination = WinningCombination(winningCombination.winningNumberList, input.toInt())
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