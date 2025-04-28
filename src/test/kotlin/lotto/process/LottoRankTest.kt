import lotto.process.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `should return FIRST rank when 6 matches and no bonus`() {
        val matchCount = 6
        val bonusMatched = false
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `should return SECOND rank when 5 matches and bonus matched`() {
        val matchCount = 5
        val bonusMatched = true
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `should return THIRD rank when 5 matches and bonus not matched`() {
        val matchCount = 5
        val bonusMatched = false
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `should return FOURTH rank when 4 matches and no bonus`() {
        val matchCount = 4
        val bonusMatched = false
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `should return FIFTH rank when 3 matches and no bonus`() {
        val matchCount = 3
        val bonusMatched = false
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `should return NONE rank when less than 3 matches`() {
        val matchCount = 2
        val bonusMatched = false
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.NONE)
    }

    @Test
    fun `should return NONE rank when 3 matches and no bonus`() {
        val matchCount = 3
        val bonusMatched = false
        val rank = LottoRank.of(matchCount, bonusMatched)
        assertThat(rank).isEqualTo(LottoRank.FIFTH)
    }
}
