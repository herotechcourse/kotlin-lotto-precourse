package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Config
import lotto.util.Messages

object InputView {

    private inline fun <T> promptUntilValid(
        prompt: String,
        parser: (String) -> T,
        crossinline validator: (T) -> Unit
    ): T {
        while (true) {
            println(prompt)
            val line = Console.readLine()
            try {
                val value = parser(line)
                validator(value)
                return value
            } catch (e: IllegalArgumentException) {
                println("\n${e.message}\nTry again")
            }
        }
    }

    fun readPurchaseAmount(): Int = promptUntilValid(
        Messages.Prompt.PURCHASE_AMOUNT,
        { raw ->
            raw.toIntOrNull()
                ?: throw IllegalArgumentException(Messages.Error.NOT_A_NUMBER.format(raw))
        },
        { amount ->
            require(amount >= Config.TICKET_PRICE && amount % Config.TICKET_PRICE == 0) {
                Messages.Error.NOT_MULTIPLE_OF_TICKET_PRICE.format(amount)
            }
        }
    )

    fun readWinningNumbers(): List<Int> = promptUntilValid(
        Messages.Prompt.WINNING_NUMBERS,
        { raw ->
            if (!raw.contains(",")) throw IllegalArgumentException(Messages.Error.MALFORMED_LIST.format(raw))
            raw.split(",").mapIndexed { idx, part ->
                val trimmed = part.trim()
                if (trimmed.isEmpty()) throw IllegalArgumentException(Messages.Error.EMPTY_VALUE_AT.format(idx + 1))
                trimmed.toIntOrNull()
                    ?: throw IllegalArgumentException(Messages.Error.INVALID_INTEGER.format(trimmed))
            }
        },
        { list ->
            require(list.size == Config.LOTTO_NUMBER_COUNT &&
                    list.all { it in Config.LOTTO_MIN_NUMBER..Config.LOTTO_MAX_NUMBER }
            ) {
                Messages.Error.OUT_OF_RANGE.format(list)
            }
            require(list.distinct().size == Config.LOTTO_NUMBER_COUNT) {
                Messages.Error.NUMBERS_NOT_UNIQUE
            }
        }
    )

    fun readBonusNumber(winningNumbers: List<Int>): Int = promptUntilValid(
        Messages.Prompt.BONUS_NUMBER,
        { raw ->
            raw.toIntOrNull()
                ?: throw IllegalArgumentException(Messages.Error.NOT_A_NUMBER.format(raw))
        },
        { bonus ->
            require(bonus in Config.LOTTO_MIN_NUMBER..Config.LOTTO_MAX_NUMBER) {
                Messages.Error.INVALID_BONUS_NUMBER.format(bonus)
            }
            require(!winningNumbers.contains(bonus)) {
                Messages.Error.BONUS_DUPLICATE
            }
        }
    )
}