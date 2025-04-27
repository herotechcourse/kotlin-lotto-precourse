package lotto
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    private val lottoMachine = LottoMachine()
    @Test
    fun `should return Rank1 when 6 matches`() {
        val result = LottoMachine.PrizeRank.of(6, false)
        assertThat(result).isEqualTo(LottoMachine.PrizeRank.Rank1)
    }

    @Test
    fun `should return Rank1 when 5 matches and bonus number match`() {
        val result = LottoMachine.PrizeRank.of(5, true)
        assertThat(result).isEqualTo(LottoMachine.PrizeRank.Rank2)
    }

    @Test
    fun `should return Rank1 when 5 matches`() {
        val result = LottoMachine.PrizeRank.of(5, false)
        assertThat(result).isEqualTo(LottoMachine.PrizeRank.Rank3)
    }

    @Test
    fun `should return Rank1 when 4 matches`() {
        val result = LottoMachine.PrizeRank.of(4, false)
        assertThat(result).isEqualTo(LottoMachine.PrizeRank.Rank4)
    }

    @Test
    fun `should return Rank1 when 3 matches`() {
        val result = LottoMachine.PrizeRank.of(3, false)
        assertThat(result).isEqualTo(LottoMachine.PrizeRank.Rank5)
    }

    @Test
    fun `should return Rank1 when I have less than 3 matches`() {
        val result = LottoMachine.PrizeRank.of(1, false)
        assertThat(result).isEqualTo(LottoMachine.PrizeRank.None)
    }

    @Test
    fun `should return total return rate`() {
        val result = lottoMachine.ProfitCalculation(5000,8000)
        assertThat(result).isEqualTo(62.5)
    }

    @Test
    fun `should return as 0 total return rate`() {
        val result = lottoMachine.ProfitCalculation(0,5000)
        assertThat(result).isEqualTo(0.0)
    }

    @Test
    fun `should match the numbers`() {
        val result = lottoMachine.MatchNumbers(7, listOf(listOf(1,2,3,4,5,6), listOf(2,3,4,5,6,7)), listOf(1,3,4,5,6,2))
        assertThat(result).isEqualTo(2030000000)
    }
}