package lotto.domain.prize

import lotto.domain.PurchaseAmount
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

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

    @ParameterizedTest
    @MethodSource("givePrizeResult")
    fun `test calculating profit rate`(repository: EnumMap<Rank, Int>, amount: Int, profitRate: Float) {
        val prizeResult = PrizeResult(repository)
        val purchaseAmount = PurchaseAmount(amount)
        Assertions.assertEquals(prizeResult.calculateProfitRate(purchaseAmount), profitRate)
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

        @JvmStatic
        fun givePrizeResult(): List<Arguments> {
            return listOf(
                Arguments.of(
                    EnumMap<Rank, Int>(Rank::class.java).apply {
                        put(Rank.FIFTH, 1)
                        put(Rank.FOURTH, 0)
                        put(Rank.THIRD, 0)
                        put(Rank.SECOND, 0)
                        put(Rank.FIRST, 0)
                    },
                    8_000,
                    62.5f
                )
            )
        }
    }
}