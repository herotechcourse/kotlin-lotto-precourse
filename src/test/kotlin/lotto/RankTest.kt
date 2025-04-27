package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RankTest {
    @Test
    fun `getPrizeMoneyInKRW returns correct prize money for each rank` () {
        assert(Rank.FIRST.getPrizeMoneyInKRW() == "2,000,000,000 KRW")
        assert(Rank.SECOND.getPrizeMoneyInKRW() == "1,500,000 KRW")
        assert(Rank.THIRD.getPrizeMoneyInKRW() == "30,000,000 KRW")
        assert(Rank.FOURTH.getPrizeMoneyInKRW() == "50,000 KRW")
        assert(Rank.FIFTH.getPrizeMoneyInKRW() == "5,000 KRW")
    }
}
