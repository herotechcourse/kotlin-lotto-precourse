package lotto.domain.prize

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PrizeResultTest {
    @ParameterizedTest
    @MethodSource("giveRankConditions")
    @DisplayName("[Success] Each time a rank is stored, the count increases by 1")
    fun `test storing rank count`(conditions: Pair<Int, Boolean>) {
        val prizeResult = PrizeResult.create()
        prizeResult.addRankBy(conditions.first, conditions.second)
        val rank = Rank.find(conditions.first, conditions.second)

        Assertions.assertEquals(prizeResult.count(rank), 1)
    }

    @ParameterizedTest
    @MethodSource("giveAllRanks")
    @DisplayName("[Success] all init count of rank starts from zero")
    fun `test rank initialization`(rank: Rank) {
        val prizeResult = PrizeResult.create()
        Assertions.assertEquals(prizeResult.count(rank), 0)
    }

    companion object {
        @JvmStatic
        fun giveAllRanks(): List<Rank> {
            return listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FIFTH, Rank.FIFTH, Rank.NONE)
        }

        @JvmStatic
        fun giveRankConditions(): List<Pair<Int, Boolean>> {
            return listOf(
                6 to false,
                5 to true,
                5 to false,
                4 to false,
                3 to false
            )
        }
    }
}