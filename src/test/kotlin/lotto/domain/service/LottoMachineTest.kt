package lotto.domain.service

import lotto.config.NumberGenerator
import lotto.domain.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val lottoGenerator = LottoGenerator(FakeNumberGenerator())
    private val money = Money(3000)
    private val lottoMachine = LottoMachine(lottoGenerator, money = money)

    private fun winningNumbers(): WinningNumbers {
        return lottoMachine.createWinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
    }

    @Test
    @DisplayName("Creates WinningNumbers using the provided main numbers and bonus number")
    fun createsWinningNumbersWithProvidedNumbers() {
        // when
        val winningNumbers = lottoMachine.createWinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // then
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumbers.winningNumber.numbers)
        assertEquals(7, winningNumbers.bonusNumber.number)
    }

    @Test
    @DisplayName("Issues lotties based on the amount of money provided")
    fun issuesLottiesBasedOnMoney() {
        // when
        val lotties = lottoMachine.issueLotties()

        // then
        assertEquals(3, lotties.value.size)
    }

    @Test
    @DisplayName("Calculates correct win result for given lotties and winning numbers")
    fun calculatesWinResultCorrectly() {
        // given
        val winningNumbers = winningNumbers()
        val lotties = Lotties(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
                Lotto(listOf(1, 2, 3, 4, 5, 8))
            )
        )

        // when
        val result = lottoMachine.calculateResult(lotties, winningNumbers)

        // then
        assertEquals(1, result.getResult()[Rank.FIRST])
        assertEquals(1, result.getResult()[Rank.SECOND])
        assertEquals(1, result.getResult()[Rank.THIRD])
    }
}

class FakeNumberGenerator : NumberGenerator {
    private var count = 0

    override fun generate(): List<Int> {
        count++
        return when (count) {
            1 -> listOf(1, 2, 3, 4, 5, 6)
            2 -> listOf(7, 8, 9, 10, 11, 12)
            else -> listOf(13, 14, 15, 16, 17, 18)
        }
    }
}
