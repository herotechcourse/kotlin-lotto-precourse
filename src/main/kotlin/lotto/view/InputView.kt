package lotto.view

import camp.nextstep.edu.missionutils.Console

/**
 * Handles all console input for the Lotto game.
 */
object InputView {
    /** Reads the purchase amount as raw string */
    fun readPurchaseAmount(): String =
        Console.readLine()

    /** Reads the winning numbers as raw string */
    fun readWinningNumbers(): String =
        Console.readLine()

    /** Reads the bonus number as raw string */
    fun readBonusNumber(): String =
        Console.readLine()
}
