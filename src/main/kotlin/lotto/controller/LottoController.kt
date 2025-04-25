package lotto.controller

import lotto.Lotto
import lotto.config.LottoConfig
import lotto.domain.LottoProfitCalculator
import lotto.domain.Lottos
import lotto.util.runCatchingRepeatedly

class LottoController(
    private val config: LottoConfig
) {
    fun run() {
        val inputView = config.inputView()
        val outputView = config.outputView()

        outputView.printPurchaseLottoAmountPrompt()
        val amount = runCatchingRepeatedly {
            config.lottoAmountInputParser().parseToInt(inputView.readPurchaseLottoAmount())
        }

        val count = config.lottoAmountCounter().count(amount)
        outputView.printIssuedLottoCountMessage(count)

        val lottos = config.lottoGenerator().generate(count)
        outputView.printIssuedLottoNumbers(lottos)

        println()
        outputView.printWinningNumbersInputPrompt()
        val winningNumbers = runCatchingRepeatedly {
            config.winningNumbersInputParser().parse(inputView.readWinningNumbers())
        }

        outputView.printBonusNumberInputPrompt()
        val bonusNumber = runCatchingRepeatedly {
            val bonus = config.bonusNumberInputParser().parse(inputView.readBonusNumber())
            bonus.validateNotDuplicateWith(Lotto(winningNumbers))
            bonus
        }

        outputView.printWinningStatisticsIntroMessage()
        val results = Lottos(lottos).results(winningNumbers, bonusNumber)
        val profitRate = LottoProfitCalculator(results, amount).calculate()
        outputView.printLottoResult(results)
        outputView.printProfitRate(profitRate)
    }
}
