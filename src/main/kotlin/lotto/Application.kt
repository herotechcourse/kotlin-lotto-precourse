package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView


fun main() {
    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    println("Winning numbers: $winningNumbers")
    println("Bonus number: $bonusNumber")
}