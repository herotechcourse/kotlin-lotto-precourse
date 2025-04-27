package lotto


fun main() {
    val purchaseAmount = getPurchaseAmountWithRetry()
    val game = LottoGame(purchaseAmount)
    OutputView().displayPurchaseDetails(game.getNumberOfTickets(), game.tickets)

    val winningNumbers = getWinningNumbersWithRetry()
    val bonusNumber = getBonusNumberWithRetry(winningNumbers)

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    val results = game.determineResults(winningLotto)
    val profitRate = game.calculateProfitRate(results)
    OutputView().displayResults(results, profitRate)
}


fun getPurchaseAmountWithRetry(): Int {
    var purchaseAmount: Int? = null
    var retryCount = 0
    while (purchaseAmount == null && retryCount < 2) { // Allow 2 attempts (1 initial + 1 retry)
        try {
            purchaseAmount = InputView().readPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retryCount++
        }
        if (retryCount == 2) {
            return InputView().readPurchaseAmount()
        }
    }
    return purchaseAmount!!
}

fun getWinningNumbersWithRetry(): List<Int> {
    var winningNumbers: List<Int>? = null
    var retryCount = 0
    while (winningNumbers == null && retryCount < 2) {
        try {
            winningNumbers = InputView().readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retryCount++
        }
        if (retryCount == 2) {
            return InputView().readWinningNumbers()
        }
    }
    return winningNumbers!!
}

fun getBonusNumberWithRetry(winningNumbers: List<Int>): Int {
    var bonusNumber: Int? = null
    var retryCount = 0;
    while (bonusNumber == null && retryCount < 2) {
        try {
            bonusNumber = InputView().readBonusNumber(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retryCount++
        }
        if (retryCount == 2) {
            return InputView().readBonusNumber(winningNumbers)
        }
    }
    return bonusNumber!!
}

