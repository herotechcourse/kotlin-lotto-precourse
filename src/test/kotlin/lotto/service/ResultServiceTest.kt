import lotto.Lotto
import lotto.service.ResultService
import lotto.domain.WinningNumbers
import lotto.domain.PrizeRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ResultServiceTest {

    @Nested
    @DisplayName("evaluateTicket() Tests")
    inner class EvaluateTicketTest {

        private val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)

        private fun createTicket(numbers: List<Int>) = Lotto(numbers)

        @ParameterizedTest
        @CsvSource(
            "1,2,3,4,5,6,FIRST",
            "1,2,3,4,5,7,SECOND",
            "1,2,3,4,5,8,THIRD",
            "1,2,3,4,7,8,FOURTH",
            "1,2,3,7,8,9,FIFTH",
            "1,2,7,8,9,10,NONE"
        )
        @DisplayName("Should evaluate correct PrizeRank based on matching numbers and bonus")
        fun evaluatePrizeRanks(
            n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int, expectedRankName: String
        ) {
            val ticket = createTicket(listOf(n1, n2, n3, n4, n5, n6))
            val result = ResultService.evaluateTicket(ticket, winningNumbers)

            assertThat(result.prizeRank).isEqualTo(PrizeRank.valueOf(expectedRankName))
        }
    }
}