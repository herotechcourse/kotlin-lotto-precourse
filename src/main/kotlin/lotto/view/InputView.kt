package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Config
import lotto.util.Messages

object InputView {
    fun readPurchaseAmount(): Int = readIntWithValidation(Messages.Prompt.PURCHASE_AMOUNT) { number ->
            number >= Config.TICKET_PRICE && number % Config.TICKET_PRICE == 0 || throw IllegalArgumentException(Messages.Error.NOT_MULTIPLE_OF_TICKET_PRICE.format(number))
        }

        fun readWinningNumbers(): List<Int> = readIntListWithValidation(Messages.Prompt.WINNING_NUMBERS) { list ->
            list.size == 6 && list.all { num -> num in 1..45 } || throw IllegalArgumentException(Messages.Error.OUT_OF_RANGE.format(list))
            list.distinct().size == 6 || throw IllegalArgumentException(Messages.Error.NUMBERS_NOT_UNIQUE)
        }

        fun readBonusNumber(winningNumbers: List<Int>): Int = readIntWithValidation(Messages.Prompt.BONUS_NUMBER) { number ->
            number in 1..45 || throw IllegalArgumentException(Messages.Error.INVALID_BONUS_NUMBER.format(number))
            !winningNumbers.contains(number) || throw IllegalArgumentException(Messages.Error.BONUS_DUPLICATE)
        }

        private fun readIntWithValidation(prompt: String, validate: (Int) -> Boolean): Int {
            while (true) {
                println(prompt)
                val input = Console.readLine()
                val number = input.toIntOrNull()
                if (number == null) {
                    println(Messages.Error.NOT_A_NUMBER.format(input))
                    continue
                }
                try {
                    if (!validate(number)) throw IllegalArgumentException(Messages.Error.INPUT_DOES_NOT_MEET_CRITERIA)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                    continue
                }
                return number
            }
        }

        private fun readIntListWithValidation(prompt: String, validate: (List<Int>) -> Boolean): List<Int> {
            while (true) {
                println(prompt)
                val input = Console.readLine()
                if (!input.contains(",")) {
                    println(Messages.Error.MALFORMED_LIST.format(input))
                    continue
                }
                val list = try {
                    input.split(",").mapIndexed { index, raw ->
                        val trimmed = raw.trim()
                        if (trimmed.isEmpty()) throw IllegalArgumentException(Messages.Error.EMPTY_VALUE_AT.format(index + 1))
                        trimmed.toIntOrNull() ?: throw IllegalArgumentException(Messages.Error.INVALID_INTEGER.format(trimmed))
                    }
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                    continue
                }
                try {
                    if (!validate(list)) throw IllegalArgumentException(Messages.Error.OUT_OF_RANGE.format(list))
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                    continue
                }
                return list
            }
        }
    }

