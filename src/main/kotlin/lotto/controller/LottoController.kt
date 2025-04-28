package lotto.controller

import lotto.Lotto
import lotto.config.LottoConfig
import lotto.domain.BonusNumber
import lotto.domain.LottoProfitCalculator
import lotto.domain.Lottos
import lotto.util.runCatchingRepeatedly

class LottoController(
    config: LottoConfig
) {
    private val inputView = config.inputView()
    private val outputView = config.outputView()
    private val lottoAmountInputParser = config.lottoAmountInputParser()
    private val winningNumbersInputParser = config.winningNumbersInputParser()
    private val bonusNumberInputParser = config.bonusNumberInputParser()
    private val lottoGenerator = config.lottoGenerator()
    private val lottoTicketCalculator = config.lottoTicketCalculator()

    fun run() {
        val (amount, count) = readPurchaseAmount()
        val lottos = generateLottos(count)
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber(winningNumbers)

        printResults(lottos, winningNumbers, bonusNumber, amount)
    }

    private fun readPurchaseAmount(): Pair<Int, Int> {
        outputView.printPurchaseLottoAmountPrompt()
        return runCatchingRepeatedly {
            val amount = lottoAmountInputParser.parseToInt(inputView.readPurchaseLottoAmount())
            val count = lottoTicketCalculator.calculateTicketCount(amount)
            amount to count
        }
    }

    private fun generateLottos(count: Int): List<Lotto> {
        outputView.printIssuedLottoCountMessage(count)

        val lottos = lottoGenerator.generate(count)
        outputView.printIssuedLottoNumbers(lottos)
        outputView.printLine()
        return lottos
    }

    private fun readWinningNumbers(): Lotto {
        outputView.printWinningNumbersInputPrompt()
        return runCatchingRepeatedly {
            Lotto(winningNumbersInputParser.parse(inputView.readWinningNumbers()))
        }
    }

    private fun readBonusNumber(winningNumbers: Lotto): BonusNumber {
        outputView.printBonusNumberInputPrompt()
        return runCatchingRepeatedly {
            val bonus = bonusNumberInputParser.parse(inputView.readBonusNumber())
            bonus.validateNotDuplicateWith(winningNumbers)
            bonus
        }
    }

    private fun printResults(
        lottos: List<Lotto>,
        winningNumbers: Lotto,
        bonusNumber: BonusNumber,
        amount: Int
    ) {
        outputView.printWinningStatisticsIntroMessage()
        val results = Lottos(lottos).matchAgainst(winningNumbers, bonusNumber)
        val profitRate = LottoProfitCalculator(results, amount).calculate()
        outputView.printLottoResult(results)
        outputView.printProfitRate(profitRate)
    }
}



