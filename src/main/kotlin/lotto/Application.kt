package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.LottoGenerator
import lotto.domain.WinningLotto
import lotto.domain.LottoManager

fun main() {
    val purchaseAmount = readValidPurchaseAmount()
    val ticketCount = purchaseAmount / 1000
    val lottos = LottoGenerator.generateLottos(ticketCount)
    OutputView.printPurchasedTickets(lottos)


    val winningNumbers = readValidWinningNumbers()
    val bonusNumber = readValidBonusNumber()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)


    val lottoManager = LottoManager(lottos)
    val result = lottoManager.matchLottos(winningLotto)

    OutputView.printStatistics(result, purchaseAmount)
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }
}

fun readValidPurchaseAmount(): Int {
    try {
        val amount = InputView.readPurchaseAmount()
        validatePurchaseAmount(amount)
        return amount
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return readValidPurchaseAmount()
    }
}

fun readValidWinningLotto(): WinningLotto {
    return try {
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()
        WinningLotto(winningNumbers, bonusNumber)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        readValidWinningLotto()
    }
}

fun readValidBonusNumber(): Int {
    return try {
        val bonusNumber = InputView.readBonusNumber()
        bonusNumber
    } catch (e: IllegalArgumentException) {
        println(e.message)
        readValidBonusNumber()
    }
}

fun readValidWinningNumbers(): List<Int> {
    return try {
        val winningNumbers = InputView.readWinningNumbers()
        validateWinningNumbers(winningNumbers)
        winningNumbers
    } catch (e: IllegalArgumentException) {
        println(e.message)
        readValidWinningNumbers()
    }
}


fun validateWinningNumbers(numbers: List<Int>) {
    if (numbers.size != 6) {
        throw IllegalArgumentException("[ERROR] Exactly 6 winning numbers must be provided.")
    }
    if (numbers.toSet().size != 6) {
        throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
    }
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
    }
}


