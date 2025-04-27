package lotto

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
    fun `throws an exception when lotto numbers are not within 1 to 45 range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 55, 5))
        }
    }

    @Test
    fun `number of matches returns a number of matches`(){
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        assert(lotto.numberOfMatches(listOf(1,2,3,4,5,6)) == 6)
        assert(lotto.numberOfMatches(listOf(1,2,3,4,5,12)) == 5)
        assert(lotto.numberOfMatches(listOf(1,22,3,4,5,12)) == 4)
        assert(lotto.numberOfMatches(listOf(11,21,30,45,55,66)) == 0)
    }

    @Test
    fun `if bonus number is already contained in numbers, bonusRepeatsNumbers returns true`(){
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        assert(lotto.bonusRepeatsNumber(5))
    }
}
