package lotto.service
import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms

import lotto.exception.LottoInputException

object LottoService {
    fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0 || amount % 1000 != 0)
            throw LottoInputException.InvalidAmount(amount)
    }

    fun generateTickets(amount: Int): List<Lotto> = List<Lotto>(amount) {
            val ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(ticketNumbers)
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.distinct().size != 6)
            throw LottoInputException.InvalidWinningNumbers("Winning numbers must all be unique.")
        if (numbers.any { it !in 1..45 })
            throw LottoInputException.InvalidWinningNumbers("Numbers must be between 1 and 45.")
    }

    fun validateBonusNumber(bonus: Int) {
        if (bonus !in 1..45)
            throw LottoInputException.InvalidBonusNumber(bonus)
    }
}