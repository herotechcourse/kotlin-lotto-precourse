package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.validation.WinningNumberValidator
import lotto.Lotto

private val validator = WinningNumberValidator()

class WinningNumberInputReader {

    fun read(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine() // Read the input from the user

                // Validate the input contains a comma separator
                validator.containsCommaSeparator(input)

                // Split the input by commas, trim spaces, validate each number
                val numbers = input.split(",")
                    .map { it.trim() }
                    .onEach { validator.validateIsNumber(it) } // Validate each number is a valid integer
                    .map { it.toInt() } // Convert to integer after validation

                // Use Lotto class validation
                Lotto(numbers)

                return numbers

            } catch (e: IllegalArgumentException) {
                // Print the error message if an exception occurs
                println(e.message)
            }
        }
    }
}