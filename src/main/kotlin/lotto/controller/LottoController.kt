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
        val amount = readPurchaseAmount()
        val lottos = generateLottos(amount)
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber(winningNumbers)

        printResults(lottos, winningNumbers, bonusNumber, amount)
    }

    private fun readPurchaseAmount(): Int {
        outputView.printPurchaseLottoAmountPrompt()
        return runCatchingRepeatedly {
            lottoAmountInputParser.parseToInt(inputView.readPurchaseLottoAmount())
        }
    }

    private fun generateLottos(amount: Int): List<Lotto> {
        val count = lottoTicketCalculator.calculateTicketCount(amount)
        outputView.printIssuedLottoCountMessage(count)

        val lottos = lottoGenerator.generate(count)
        outputView.printIssuedLottoNumbers(lottos)
        outputView.printLine()
        return lottos
    }

    private fun readWinningNumbers(): List<Int> {
        outputView.printWinningNumbersInputPrompt()
        return runCatchingRepeatedly {
            winningNumbersInputParser.parse(inputView.readWinningNumbers())
        }
    }

    private fun readBonusNumber(winningNumbers: List<Int>): BonusNumber {
        outputView.printBonusNumberInputPrompt()
        return runCatchingRepeatedly {
            val bonus = bonusNumberInputParser.parse(inputView.readBonusNumber())
            bonus.validateNotDuplicateWith(Lotto(winningNumbers))
            bonus
        }
    }

    private fun printResults(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
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



