package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    private class FakeNumberGenerator : NumberGenerator {
        private var callCount = 0
        override fun generate(): List<Int> {
            callCount++
            return listOf(1, 2, 3, 4, 5, callCount + 5)
        }
    }

    @Test
    @DisplayName("Generates lottos equal to ticket count from Money")
    fun generateLotties_returnsCorrectLottiesSize() {
        // given
        val money = Money(3000)
        val generator = LottoGenerator(FakeNumberGenerator())

        // when
        val lotties = generator.generateLotties(money)

        // then
        assertEquals(3, lotties.value.size)
    }

    @Test
    @DisplayName("Each Lotto contains numbers from the generator")
    fun generateLotties_containsGeneratedNumbers() {
        // given
        val money = Money(1000)
        val fixedNumbers = listOf(1, 2, 3, 4, 5, 6)
        val generator = object : NumberGenerator {
            override fun generate(): List<Int> = fixedNumbers
        }
        val lottoGenerator = LottoGenerator(generator)

        // when
        val lotties = lottoGenerator.generateLotties(money)

        // then
        assertEquals(lotties.value.first().matchCount(fixedNumbers), 6)
    }
}
