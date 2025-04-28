package lotto

fun main() {
    val purchaseAmount = readPurchaseAmount()
    val lottoMachine = LottoMachine()
    val lottos = lottoMachine.buyLottos(purchaseAmount)

    OutputView.printPurchaseCount(count = lottos.size)
    OutputView.printLottoNumbers(lottos)

    val winningNumbers = readWinningNumbers()
    val bonusNumber = readBonusNumber()

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    val lottoResult = LottoResult()

    lottos.forEach { lotto ->
        val matchCount = lotto.countMatchingNumbers(winningLotto.winningNumbers)
        val hasBonus = lotto.containsBonusNumber(winningLotto.bonusNumber)
        val rank = Rank.findByMatch(matchCount, hasBonus)
        lottoResult.record(rank)
    }

    OutputView.printResult(lottoResult)
    OutputView.printProfitRate(profitRate = lottoResult.calculateProfitRate(purchaseAmount))
}

fun readPurchaseAmount(): Int {
    while (true) {
        try {
            return InputView.readPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
        }
    }
}

fun readWinningNumbers(): List<Int> {
    while (true) {
        try {
            return InputView.readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
        }
    }
}

fun readBonusNumber(): Int {
    while (true) {
        try {
            return InputView.readBonusNumber()
        } catch (e: IllegalArgumentException) {
            println("[ERROR]")
        }
    }
}