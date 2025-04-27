package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.exception.ExceptionMessage
import lotto.model.LottoResult
import lotto.model.PrizeRank
import lotto.model.WinningLotto

class LottoService {
    fun createLottoTickets(amount: Int): List<Lotto> {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT.message)
        }

        val ticketCount = amount / 1000
        return List(ticketCount) { generateRandomLotto() }
    }

    private fun generateRandomLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_WINNING_LOTTO_SIZE.message)
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_RANGE.message)
        }
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBERS.message)
        }
    }

    fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_BONUS_RANGE.message)
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException(ExceptionMessage.BONUS_IN_WINNING_NUMBERS.message)
        }
    }

    fun matchLottos(tickets: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val results = PrizeRank.values().associateWith { 0 }.toMutableMap()

        tickets.forEach { ticket ->
            val rank = winningLotto.match(ticket)
            if(rank != PrizeRank.NONE) {
                results[rank] = results[rank]!! + 1
            }
        }

        return LottoResult(results, tickets.size)
    }
}