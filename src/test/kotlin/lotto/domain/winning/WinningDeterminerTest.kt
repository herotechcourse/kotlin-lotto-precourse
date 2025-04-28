package lotto.domain.winning

import lotto.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class WinningDeterminerTest {
    @ParameterizedTest
    @MethodSource("giveLottoAndWinningNumbers")
    @DisplayName("[Success] Lotto and WinningNumbers share 4 numbers, resulting in a match count of 4")
    fun `test determining match count`(numbers: Pair<Lotto, WinningNumbers>) {
        val matchCount = WinningDeterminer.determineMatchCount(numbers.first, numbers.second)
        Assertions.assertThat(matchCount).isEqualTo(4)
    }

    @ParameterizedTest
    @MethodSource("giveLottoAndBonusNumber")
    @DisplayName("[Success] Bonus match is true when Lotto contains the bonus number")
    fun `test determining bonus match`(numbers: Pair<Lotto, BonusNumber>) {
        val bonusMatch = WinningDeterminer.determineBonusMatch(numbers.first, numbers.second)
        Assertions.assertThat(bonusMatch).isTrue()
    }

    companion object {
        @JvmStatic
        fun giveLottoAndWinningNumbers(): List<Pair<Lotto, WinningNumbers>> {
            return listOf(
                //rank FOURTH
                Lotto(listOf(7, 8, 3, 10, 20, 30)) to WinningNumbers.from("1,2,3,10,20,30"),
                //rank FOURTH
                Lotto(listOf(21, 23, 24, 40, 42, 44)) to WinningNumbers.from("22,23,24,40,42,45"),
            )
        }

        @JvmStatic
        fun giveLottoAndBonusNumber(): List<Pair<Lotto, BonusNumber>> {
            val winningNumbers = WinningNumbers.from("1,2,7,10,20,30")
            return listOf(
                //rank FOURTH
                Lotto(listOf(7, 8, 3, 10, 20, 30)) to BonusNumber.from(3, winningNumbers),
                //rank FOURTH
                Lotto(listOf(21, 23, 24, 40, 42, 44)) to BonusNumber.from(24, winningNumbers),
            )
        }
    }
}