package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    @Nested
    @DisplayName("LottoMachine purchase tests")
    inner class PurchaseTest {

        @Test
        @DisplayName("should return correct number of lottos based on money amount")
        fun shouldReturnCorrectNumberOfLottos() {
            // Given
            val money = Money(5000)

            // When
            val lottos = LottoMachine.purchase(money)

            // Then
            assertThat(lottos).hasSize(5)
        }

        @ParameterizedTest
        @ValueSource(ints = [1000, 2000, 3000, 10000, 15000])
        @DisplayName("should return lottos proportional to money amount")
        fun shouldReturnLottosProportionalToMoney(amount: Int) {
            // Given
            val money = Money(amount)
            val expectedLottoCount = amount / 1000

            // When
            val lottos = LottoMachine.purchase(money)

            // Then
            assertThat(lottos).hasSize(expectedLottoCount)
        }

        @Test
        @DisplayName("should create lottos with valid numbers")
        fun shouldCreateLottosWithValidNumbers() {
            // Given
            val money = Money(1000)

            // When
            val lottos = LottoMachine.purchase(money)

            // Then
            assertThat(lottos).isNotEmpty
            lottos.forEach { lotto ->
                assertThat(lotto.getNumbers()).hasSize(6)
                assertThat(lotto.getNumbers()).allMatch { it in 1..45 }
                assertThat(lotto.getNumbers()).doesNotHaveDuplicates()
            }
        }
    }

    @Nested
    @DisplayName("LottoMachine simulate tests")
    inner class SimulateTest {

        @Test
        @DisplayName("should return prizes for each lotto")
        fun shouldReturnPrizesForEachLotto() {
            // Given
            val lottos = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12))
            )
            val winner = Winner(listOf(1, 2, 3, 4, 5, 6), 7)

            // When
            val prizes = LottoMachine.simulate(lottos, winner)

            // Then
            assertThat(prizes).hasSize(2)
        }

        @Test
        @DisplayName("should correctly identify matching numbers and bonus")
        fun shouldCorrectlyIdentifyMatchingNumbersAndBonus() {
            // Given
            val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            val bonusNumber = 7
            val winner = Winner(winningNumbers, bonusNumber)

            val perfectMatch = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val fiveMatchPlusBonus = Lotto(listOf(1, 2, 3, 4, 5, 7))
            val fiveMatch = Lotto(listOf(1, 2, 3, 4, 5, 8))
            val fourMatch = Lotto(listOf(1, 2, 3, 4, 10, 11))
            val threeMatch = Lotto(listOf(1, 2, 3, 10, 11, 12))
            val noMatch = Lotto(listOf(20, 21, 22, 23, 24, 25))

            val lottos = listOf(
                perfectMatch, fiveMatchPlusBonus, fiveMatch,
                fourMatch, threeMatch, noMatch
            )

            // When
            val prizes = LottoMachine.simulate(lottos, winner)

            // Then
            assertThat(prizes).hasSize(6)

            assertThat(prizes[0].getRank().matchCount).isEqualTo(6)
            assertThat(prizes[0].getRank().isMatchBonus).isFalse()

            assertThat(prizes[1].getRank().matchCount).isEqualTo(5)
            assertThat(prizes[1].getRank().isMatchBonus).isTrue()

            assertThat(prizes[2].getRank().matchCount).isEqualTo(5)
            assertThat(prizes[2].getRank().isMatchBonus).isFalse()

            assertThat(prizes[3].getRank().matchCount).isEqualTo(4)
            assertThat(prizes[3].getRank().isMatchBonus).isFalse()

            assertThat(prizes[4].getRank().matchCount).isEqualTo(3)
            assertThat(prizes[4].getRank().isMatchBonus).isFalse()

            assertThat(prizes[5].getRank().matchCount).isEqualTo(0)
            assertThat(prizes[5].getRank().isMatchBonus).isFalse()
        }
    }
}