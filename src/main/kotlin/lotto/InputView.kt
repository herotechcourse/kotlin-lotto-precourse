package lotto

import camp.nextstep.edu.missionutils.Console


object InputView {

    fun readPurchaseAmount(): Long = retryUserInput {
        val amount = Console.readLine().toLong()
        Validator.validateAmount(amount)
        amount
    }

    fun readWinningNumbers(): List<Int> = retryUserInput {
        val numbers = Console.readLine()
            .split(",")
            .map { it.trim().toInt() }
        Validator.validateWinningNumbers(numbers)
        numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int = retryUserInput {
        val bonus = Console.readLine().toInt()
        Validator.validateBonusNumber(bonus, winningNumbers)
        bonus
    }

    private inline fun <T> retryUserInput(block: () -> T): T {
        while (true) {
            runCatching { block() }
                .onSuccess { return it }
                .onFailure { throwable -> handleFailure(throwable) }
        }
    }

    private fun handleFailure(throwable: Throwable) {
        when (throwable) {
            is IllegalArgumentException, is IllegalStateException -> {
                println("$ERROR_PREFIX ${throwable.message}")
            }
            else -> throw throwable
        }
    }
}