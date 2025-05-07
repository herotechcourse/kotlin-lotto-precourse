package lotto

import camp.nextstep.edu.missionutils.Randoms

private const val SINGLE_TICKET_PRICE = 1_000
private const val PERCENT_RATIO = 100

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoValidator: LottoValidator
) {

    fun start() {
        val numberOfTickets = getNumberOfTickets()

        val lottoTickets = generateLottoTickets(numberOfTickets)
        displayPurchasedTickets(lottoTickets)

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)

        displayResult(lottoTickets, winningNumbers, bonusNumber)
    }

    private fun getNumberOfTickets(): Int = repeatUntilSuccess {
        val amount = inputView.readPurchaseAmount()
        lottoValidator.validatePurchaseAmount(amount)
        amount.toInt() / SINGLE_TICKET_PRICE
    }

    private fun generateLottoTickets(numberOfTickets: Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottoTickets.add(lotto)
        }
        return lottoTickets
    }

    private fun displayPurchasedTickets(lottoTickets: List<Lotto>) {
        outputView.displayPurchasedTickets(lottoTickets)
    }

    private fun getWinningNumbers(): Lotto = repeatUntilSuccess {
        val winningNumberInput: List<String> = inputView.readWinningNumbers()
        lottoValidator.validateWinningNumbers(winningNumberInput)
        Lotto(winningNumberInput.map { it.toInt() })
    }


    private fun getBonusNumber(winningNumbers: Lotto): Int = repeatUntilSuccess {
        val bonusNumberInput = inputView.readBonusNumber()
        lottoValidator.validateBonusNumber(bonusNumberInput, winningNumbers)
        bonusNumberInput.toInt()
    }

    private fun <T> repeatUntilSuccess(actionToRetry: () -> T): T {
        while (true) {
            try {
                return actionToRetry()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                println()
            }
        }
    }

    private fun displayResult(lottoTickets: List<Lotto>, winningNumbers: Lotto, bonusNumber: Int) {
        val prizeCounts: IntArray = getPrizeCounts(lottoTickets, winningNumbers, bonusNumber)
        val matchedPrizes: MutableMap<Prize, Int> = getMatchedPrizes(prizeCounts)

        outputView.displayPrizeDistribution(matchedPrizes)

        val returnRate = getReturnRate(matchedPrizes, lottoTickets.size)

        outputView.displayTotalReturnRate(returnRate)
    }

    private fun getReturnRate(matchedPrizes: MutableMap<Prize, Int>, countOfLotto: Int): Double {
        val totalWinnings = matchedPrizes.entries.sumOf { (prize, count) -> prize.money * count }
        val totalTicketPrice = countOfLotto * SINGLE_TICKET_PRICE.toDouble()

        val returnRate = totalWinnings / totalTicketPrice * PERCENT_RATIO
        return returnRate
    }

    private fun getPrizeCounts(lottoTickets: List<Lotto>, winningNumbers: Lotto, bonusNumber: Int): IntArray {
        val prizeCounts: IntArray = IntArray(6)
        for (lottoTicket in lottoTickets) {
            val prize = lottoTicket.prizeCount(winningNumbers, bonusNumber)
            prizeCounts[prize]++
        }
        return prizeCounts
    }

    private fun getMatchedPrizes(prizeCounts: IntArray): MutableMap<Prize, Int> {
        var index = 1
        return Prize.entries.associateWith { prizeCounts[index++]}
            .toMutableMap()
    }
}