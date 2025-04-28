package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features

    @Test
    fun `compare user's ticket list and winner's number list, and return how many numbers are identical`(){
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).eachCompare(listOf(1,2,3,4,5,6))).isEqualTo(6)
    }

    @Test
    fun `return zero if user's tickets don't match any numbers`(){
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).sumOfMoney()).isEqualTo(0)
    }
    @Test
    fun `add 1 if winner is equal the match Type`(){
        Lotto(listOf(1, 2, 3, 4, 5, 6)).makeWinnerMap("5")
        assertThat(Prize.THIRD.cnt).isEqualTo(1)
    }
    @Test
    fun `return profitRate`(){
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)).profitRate("8000",8000)).isEqualTo(100.0)
    }


}
