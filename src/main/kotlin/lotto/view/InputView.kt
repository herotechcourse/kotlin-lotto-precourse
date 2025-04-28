package lotto.view

import camp.nextstep.edu.missionutils.Console

private object RequestMessage {
    const val PAYMENT = "Please enter the amount of money you want to spend."
    const val WINNING_NUMBERS = "Please enter the winning numbers."
    const val BONUS_NUMBER = "Please enter the bonus number."
}

private object ErrorMessage {
    const val PAYMENT_DIVISION = "[ERROR] Input must be divisible by 1,000."
    const val PAYMENT_LIMIT = "[ERROR] Input must not exceed 100,000 to avoid game overload."
    const val NON_NUMERIC = "[ERROR] Input must contain valid numbers."
    const val COMMA_FORMAT = "[ERROR] Input must be separated by commas."
    const val INVALID_RANGE = "[ERROR] Input number must be between ${lotto.MIN_RANGE} and ${lotto.MAX_RANGE}."
}

object InputView {
    fun getPayment(): Int {
        return requestUntilValid(RequestMessage.PAYMENT, ::validatePayment)
    }

    fun getWinningNumbers(): List<Int> {
        return requestUntilValid(RequestMessage.WINNING_NUMBERS, ::validateWinningNumbers)
    }


    fun getBonusNumber(): Int {
        return requestUntilValid(RequestMessage.BONUS_NUMBER, ::validateBonusNumber)
    }

    private fun validatePayment(input: String): Int {
        val parsedInput = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.NON_NUMERIC)
        require(parsedInput % 1000 == 0) { ErrorMessage.PAYMENT_DIVISION }
        require(parsedInput <= 100000) { ErrorMessage.PAYMENT_LIMIT }
        return parsedInput
    }

    private fun validateWinningNumbers(input: String): List<Int> {
        require(input.contains(",")) { ErrorMessage.COMMA_FORMAT }
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        if (numbers.any { it == null }) {
            throw IllegalArgumentException(ErrorMessage.NON_NUMERIC)
        }
        return numbers.filterNotNull()
    }

    private fun validateBonusNumber(input: String): Int {
        val parsedInput = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.NON_NUMERIC)
        require(parsedInput in lotto.MIN_RANGE..lotto.MAX_RANGE) {
            ErrorMessage.INVALID_RANGE
        }
        return parsedInput
    }

    private fun <T> requestUntilValid(promptMessage: String, validationFunction: (String) -> T): T {
        while (true) {
            try {
                OutputView.requestUser(promptMessage)
                val input = Console.readLine() ?: ""
                return validationFunction(input)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}


