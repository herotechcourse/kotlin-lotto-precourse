package lotto

import lotto.generator.RandomNumbersGenerator
import lotto.io.InputView
import lotto.io.OutputView

fun main() {
    // TODO: Implement the program

    val amount = InputView.readPurchaseAmount()

    val lottos = LottoTicketMachine().purchase(amount, RandomNumbersGenerator())

    OutputView.printLottos(lottos)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val result = LottoResultAnalyzer().analyze(lottos, winningLotto)

    OutputView.printResult(result, amount)
}
