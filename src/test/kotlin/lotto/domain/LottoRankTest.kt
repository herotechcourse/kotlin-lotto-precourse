package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `find should return MATCH_SIX when 6 numbers match`() {
        val rank = LottoRank.find(6, false)
        assertThat(rank).isEqualTo(LottoRank.MATCH_SIX)
    }

    @Test
    fun `find should return MATCH_BONUS when 5 numbers match plus bonus`() {
        val rank = LottoRank.find(5, true)
        assertThat(rank).isEqualTo(LottoRank.MATCH_BONUS)
    }

    @Test
    fun `find should return MATCH_FIVE when 5 numbers match without bonus`() {
        val rank = LottoRank.find(5, false)
        assertThat(rank).isEqualTo(LottoRank.MATCH_FIVE)
    }

    @Test
    fun `find should return MATCH_FOUR when 4 numbers match`() {
        val rank = LottoRank.find(4, false)
        assertThat(rank).isEqualTo(LottoRank.MATCH_FOUR)
    }

    @Test
    fun `find should return MATCH_THREE when 3 numbers match`() {
        val rank = LottoRank.find(3, false)
        assertThat(rank).isEqualTo(LottoRank.MATCH_THREE)
    }

    @Test
    fun `find should return null when less than 3 numbers match`() {
        val rank = LottoRank.find(2, false)
        assertThat(rank).isNull()
    }

    @Test
    fun `displayName should return correct name for each rank`() {
        assertThat(LottoRank.MATCH_THREE.displayName()).isEqualTo("3 Matches")
        assertThat(LottoRank.MATCH_FOUR.displayName()).isEqualTo("4 Matches")
        assertThat(LottoRank.MATCH_FIVE.displayName()).isEqualTo("5 Matches")
        assertThat(LottoRank.MATCH_BONUS.displayName()).isEqualTo("5 Matches + Bonus Ball")
        assertThat(LottoRank.MATCH_SIX.displayName()).isEqualTo("6 Matches")
    }
}