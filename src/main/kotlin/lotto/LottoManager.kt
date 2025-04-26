package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoManager {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val purchaseAmount = getPurchaseAmount()
        val tickets = generateTickets(purchaseAmount)
        outputView.printPurchasedTickets(tickets)

        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)

        val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)
        outputView.printStatistics(lottoResult, purchaseAmount)
    }

    internal fun getPurchaseAmount(): Int {
        while (true) {
            try {
                val amount = inputView.readPurchaseAmount()
                validatePurchaseAmount(amount)
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    internal fun validatePurchaseAmount(amount: Int) {
        require(amount % 1000 == 0) { "[ERROR] Purchase amount must be a multiple of 1000." }
        require(amount > 0) { "[ERROR] Purchase amount must be greater than 0." }
    }

    internal fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }

    internal fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                val numbers = inputView.readWinningNumbers()
                validateWinningNumbers(numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    internal fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
    }

    internal fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    internal fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not be among the winning numbers." }
    }
}