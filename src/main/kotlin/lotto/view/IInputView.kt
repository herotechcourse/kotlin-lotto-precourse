package lotto.view

/**
 * Abstraction for reading user input.
 */
interface IInputView {
    /**
     * Reads and validates the purchase amount.
     *
     * @return the purchase amount in KRW
     * @throws IllegalArgumentException on invalid input
     */
    fun readPurchaseAmount(): Int

    /**
     * Reads and validates the winning numbers.
     *
     * @return list of 6 winning numbers
     * @throws IllegalArgumentException on invalid input
     */
    fun readWinningNumbers(): List<Int>

    /**
     * Reads and validates the bonus number.
     *
     * @return the bonus number
     * @throws IllegalArgumentException on invalid input
     */
    fun readBonusNumber(): Int
}
