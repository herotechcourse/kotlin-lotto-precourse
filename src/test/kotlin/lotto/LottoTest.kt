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
    fun `create a Lotto with exactly 6 unique numbers`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1,2,3,4,5,6)
    }

    @Test
    fun `Throw an error when creating a Lotto with less than 6 numbers`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5)

        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `Throw an error when creating lotto with duplicate numbers`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 5)

        assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }
    }

    @Test
    fun `getNumbers return a copy of the original numbers`() {
        val original = listOf(1,2,3,4,5,6)
        val lotto = Lotto(original)

        val numbersCopy = lotto.getNumbers()

        assertThat(numbersCopy).isNotSameAs(original)
    }
}
