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

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are not between 1 and 45`() {
        //given
        val invalidLotto = listOf(
            listOf(1, 2, 3, 4, 5, 46),
            listOf(0, 1, 2, 3, 4, 5)
        )

        //then
        invalidLotto.forEach { numbers ->
            assertThrows<IllegalArgumentException> {
                Lotto(numbers)
            }
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicate with bonus number`() {
        //when
        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val bonusNumber = 1

        //then
        assertThrows<IllegalArgumentException> {
            lotto.validateDuplicateWithBonusNumber(bonusNumber)
        }
    }
}
