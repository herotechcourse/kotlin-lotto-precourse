package lotto.view

import camp.nextstep.edu.missionutils.Console // TODO: remove this once sorted output/input call for remaining functions

object InputView {
    // TODO: implement reprompting of invalid input
    fun getPayment(input: String): Int {
        val parsedInput = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] spending amount must be a valid number.")
        require(parsedInput % 1000 == 0) { "[ERROR] spending amount must be divisible by 1,000." }
        require(parsedInput < 100001) { "[ERROR] spending amount must not be greater than 100,000 to avoid game overload." }
        return parsedInput
    }

    // TODO: returns winning list of inputted numbers, only parsing errors are handled for now and need to handle validation in lotto class
    fun getWinningNumbers(): List<Int> {
        OutputView.requestUser("Please enter the winning numbers.") // TODO: shouldn't be nested here, put in a higher function
        val input = Console.readLine()?.trim()
            ?: throw IllegalArgumentException("[ERROR] winning numbers should be a valid number separated by ','.")
        require(input.contains(",")) { "[ERROR] winning numbers must be separated by commas." }
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        if (numbers.any { it == null }) {
            throw IllegalArgumentException("[ERROR] winning numbers should not be null.")
        }
        val parsed = numbers.filterNotNull()
        return parsed
    }


    fun getBonusNumber(): Int {
        OutputView.requestUser("Please enter the bonus number.")// TODO: shouldn't be nested here, put in a higher function
        val input = Console.readLine().trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] bonus number was not a valid number.")
        require(input in lotto.MIN_RANGE..lotto.MAX_RANGE) { "[ERROR] bonus number must be between ${lotto.MIN_RANGE} and ${lotto.MAX_RANGE}." }
        return input
    }
}


