/**
 * input view
 */

package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        fun parsePurchaseAmount(input: String) : Int {
            val amount = input.toInt()
            InputValidator.validatePurchaseAmount(amount)

            return amount
        }

        fun getUserPurchaseAmount() : Int {
            while (true) {
                println("Please enter purchase amount: (${const.MIN_AMOUNT} <= amount <= ${const.MAX_AMOUNT}, multiple of ${const.TICKET_PRICE})")
                var input = ""
                try {
                    input = Console.readLine()

                    return parsePurchaseAmount(input)
                } catch (e: NumberFormatException) {
                    println("${const.ERROR_MESSAGE_PREFIX}Invalid value: $input")
                    continue
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                    continue
                }
            }
        }

        fun parseWinningNumbers(input: String) : List<Int> {
            val numbers = input.split(const.LOTTO_NUMBERS_DELIMITER)
                .map { it.trim().toInt() }
            InputValidator.validateWinningNumbers(numbers)

            return numbers
        }

        fun getUserWinningNumbers() : List<Int> {
            while (true) {
                println("Please enter last week's winning numbers: (${const.NUMBER_OF_LOTTO_NUMBERS} numbers, ${const.MIN_LOTTO_NUMBER} <= number <= ${const.MAX_LOTTO_NUMBER})")
                var input = ""
                try {
                    input = Console.readLine()
                    return parseWinningNumbers(input)
                } catch (e: NumberFormatException) {
                    println("${const.ERROR_MESSAGE_PREFIX}Invalid value: $input")
                    continue
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                    continue
                }
            }
        }

        fun parseBonusNumbers(input: String, winningNumbers: List<Int>) : List<Int> {
            val numbers = input.split(const.LOTTO_NUMBERS_DELIMITER)
                .map { it.trim().toInt() }
            InputValidator.validateBonusNumbers(numbers, winningNumbers)

            return numbers
        }

        fun getUserBonusNumbers(winningNumbers: List<Int>) : List<Int> {
            while (true) {
                println("Please enter the bonus numbers: (${const.NUMBER_OF_BONUS_NUMBERS} numbers, ${const.MIN_LOTTO_NUMBER} <= number <= ${const.MAX_LOTTO_NUMBER})")
                var input = ""
                try {
                    input = Console.readLine()
                    return parseBonusNumbers(input, winningNumbers)
                } catch (e: NumberFormatException) {
                    println("${const.ERROR_MESSAGE_PREFIX}Invalid value: $input")
                    continue
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                    continue
                }
            }
        }
    }
}