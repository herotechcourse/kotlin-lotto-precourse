package lotto.generator

import lotto.util.LottoConstants.COUNT
import lotto.util.LottoConstants.END_INCLUSIVE
import lotto.util.LottoConstants.START_INCLUSIVE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomNumbersGeneratorTest {

    @Test
    fun `generate returns six unique numbers within valid range`() {
        val randomNumbers = RandomNumbersGenerator().generate()

        assertEquals(randomNumbers.size, COUNT)
        assertEquals(randomNumbers.size, randomNumbers.distinct().size)
        randomNumbers.forEach { number -> assertTrue(number in START_INCLUSIVE..END_INCLUSIVE) }
    }

}