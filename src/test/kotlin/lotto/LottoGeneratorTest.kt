package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoGeneratorTest {

    @Test
    fun `generates valid lotto with six unique numbers in range`() {
        val generator = LottoGenerator()
        val lotto = generator.generate()
        val numbers = lotto.getNumbers()

        assertEquals(6, numbers.size)
        assertTrue(numbers.all { it in 1..45 })
        assertEquals(numbers.size, numbers.distinct().size)
        assertEquals(numbers, numbers.sorted())
    }
}