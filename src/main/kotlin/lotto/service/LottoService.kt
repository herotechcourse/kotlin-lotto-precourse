package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.LottoConstants
import lotto.exception.LottoInputException

/**
 * Service class responsible for handling the logic related to purchasing lotto tickets,
 * generating tickets, and validating input related to purchase amounts, winning numbers, and bonus numbers.
 */
object LottoService {
    /**
     * Validates the purchase amount to ensure it is a positive number and divisible by 1,000.
     */
    fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0 || amount % LottoConstants.TICKET_PRICE != 0)
            throw LottoInputException.InvalidAmount(amount)
    }

    /**
     * Generates a list of lotto tickets based on the purchase amount.
     */
    fun generateTickets(amount: Int) = List<Lotto>(amount) {
        val ticketNumbers = Randoms.pickUniqueNumbersInRange(
            LottoConstants.LOTTO_MIN_NUMBER,
            LottoConstants.LOTTO_MAX_NUMBER,
            LottoConstants.LOTTO_NUMBERS_COUNT
        ).sorted()
        Lotto(ticketNumbers)
    }

    /**
     * Validates the list of winning numbers to ensure they are unique and within the valid range (1 to 45).
     */
    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.distinct().size != LottoConstants.LOTTO_NUMBERS_COUNT)
            throw LottoInputException.InvalidWinningNumbers("Winning numbers must all be unique.")
        if (numbers.any { it !in LottoConstants.LOTTO_MIN_NUMBER..LottoConstants.LOTTO_MAX_NUMBER })
            throw LottoInputException.InvalidWinningNumbers("Numbers must be between 1 and 45.")
    }

    /**
     * Validates the bonus number to ensure it is valid and not part of the winning numbers.
     */
    fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        if (bonus !in LottoConstants.LOTTO_MIN_NUMBER..LottoConstants.LOTTO_MAX_NUMBER)
            throw LottoInputException.InvalidBonusNumber(bonus)
        if (winningNumbers.contains(bonus))
            throw LottoInputException.InvalidBonusWithWinningNumbers(bonus)
    }
}