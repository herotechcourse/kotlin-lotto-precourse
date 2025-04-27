package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPayment(): Int {
        return requestUntilValid {
            OutputView.requestUser("Please enter the amount of money you want to spend.")
            val input = Console.readLine().trim().toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] spending amount must be a valid number.")
            require(input % 1000 == 0) { "[ERROR] spending amount must be divisible by 1,000." }
            require(input < 100001) { "[ERROR] spending amount must not be greater than 100,000 to avoid game overload." }
            input
        }
    }

    fun getWinningNumbers(): List<Int> {
        return requestUntilValid {
            OutputView.requestUser("Please enter the winning numbers.") // TODO: check lotto error handling
            val input = Console.readLine()?.trim()
                ?: throw IllegalArgumentException("[ERROR] winning numbers should be a valid number separated by ','.")
            require(input.contains(",")) { "[ERROR] winning numbers must be separated by commas." }
            val numbers = input.split(",").map { it.trim().toIntOrNull() }
            if (numbers.any { it == null }) {
                throw IllegalArgumentException("[ERROR] winning numbers should not be null.")
            }
            val parsed = numbers.filterNotNull()
            parsed
        }
    }


    fun getBonusNumber(): Int {
        return requestUntilValid {
            OutputView.requestUser("Please enter the bonus number.")// TODO: should not be equal to any of winning numbers as in the lotto game the bonus number is extracted from the same batch
            val input = Console.readLine().trim().toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] bonus number was not a valid number.")
            require(input in lotto.MIN_RANGE..lotto.MAX_RANGE) { "[ERROR] bonus number must be between ${lotto.MIN_RANGE} and ${lotto.MAX_RANGE}." }
            input
        }
    }

    private fun <T> requestUntilValid(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}


