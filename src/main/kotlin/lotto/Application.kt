package lotto

import lotto.domain.PrizeRank
import lotto.domain.WinningLotto
import lotto.generator.LottoGenerator
import lotto.io.InputView
import lotto.io.OutputView
import lotto.service.ProfitCaculator

fun main() {
    println("Please enter the purchase amount.")
    val ticket: Int = InputView.inputPurchaseAmount(InputView.input())
    val userLottos: List<Lotto> = LottoGenerator.generate(ticket)

    OutputView.printUsertickets(userLottos)

    println("\nPlease enter last week's winning numbers.")
    val winningNumbers: List<Int> = InputView.inputWinningNumbers(InputView.input())
    val bonusNumber: Int = InputView.inputBonusNumber()

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val map = mutableMapOf<PrizeRank, Int>(
        PrizeRank.FIFTH to 0,
        PrizeRank.FOURTH to 0,
        PrizeRank.THIRD to 0,
        PrizeRank.SECOND to 0,
        PrizeRank.FIRST to 0
    )

    for (userLotto in userLottos) {
        val matchResult: Pair<Int, Boolean> = userLotto.matchNumbers(winningLotto)
        val result = PrizeRank.of(matchResult.first, matchResult.second)
        map[result] = map.getOrDefault(result, 0) + 1
    }

    OutputView.printWinningStatistics(map)

    val total = ProfitCaculator.calculate(map, ticket)
    OutputView.printProfitResult(total)

}
