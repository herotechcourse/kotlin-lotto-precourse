package lotto

fun main() {

    try {
        val amount = getValidAmount()
        println(amount)

        val (winningNumbers, bonus) = getValidWinningNumbers()
        println(bonus)

        val machine = Lotto(winningNumbers)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

private fun getValidAmount(): Int {
    while(true) {
        try {
            val amount = InputView.readAmount()
            LotteryValidator.validateAmount(amount)
            return amount
        } catch (e: Exception) {
            OutputView.printError("Invalid amount: ${e.message}")
        }
    }
}

private fun getValidWinningNumbers(): Pair<Set<Int>, Int> {
    while(true) {
        try {
            val numbers = InputView.readWinningNumbers()
            val bonus = InputView.readBonusNumber()

            LotteryValidator.validateWinningNumbers(numbers)
            LotteryValidator.validateBonusNumber(bonus, numbers)

            return numbers to bonus
        } catch (e: Exception) {
            OutputView.printError("Invalid numbers: ${e.message}")
        }
    }
}