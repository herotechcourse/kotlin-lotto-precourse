package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `generateLotto returns 6 unique numbers between 1 and 45`() {
        val lotto = LottoGenerator.generateLotto()

        assertEquals(6, lotto.getNumbers().size)
        assertTrue(lotto.getNumbers().all { it in 1..45 })
        assertEquals(6, lotto.getNumbers().toSet().size)

    }

    @Test
    fun `generateLottos returns the requested number of lottos`() {
        val count = 5
        val lottos = LottoGenerator.generateLottos(count)

        assertEquals(count, lottos.size)

        lottos.forEach { lotto ->
            assertEquals(6, lotto.getNumbers().size)
            assertTrue(lotto.getNumbers().all { it in 1..45 })
            assertEquals(6, lotto.getNumbers().toSet().size)
        }
    }
}
