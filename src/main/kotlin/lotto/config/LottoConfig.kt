package lotto.config

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoConfig {
    fun inputView(): InputView = InputView()
    fun outputView(): OutputView = OutputView()
    fun lottoAmountInputParser(): LottoAmountInputParser = LottoAmountInputParser()
    fun winningNumbersInputParser(): WinningNumbersInputParser = WinningNumbersInputParser()
    fun bonusNumberInputParser(): BonusNumberInputParser = BonusNumberInputParser()
    fun lottoNumberGenerator(): LottoNumberGenerator = RandomNumberGenerator()
    fun lottoAmountCounter(): LottoAmountCounter = LottoAmountCounter()
    fun lottoGenerator(): LottoGenerator = LottoGenerator(lottoNumberGenerator())
}
