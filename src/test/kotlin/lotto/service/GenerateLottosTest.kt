package lotto.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

/**
 *  [ Cases ]
 *  1. Generates the correct number of Lottos based on purchase count
 *  2. Each Lotto contains exactly 6 numbers
 *  3. No duplicate numbers within each lotto
 *  4. Range: 1 - 45
 */
class GenerateLottosTest {

    @Test
    fun `givenPurchaseCount_whenGenerateLottos_thenGenerateExactNumberOfLottos`() {
        // given
        val count = 10

        // when
        val lottos = GenerateLottos.generate(count)

        // then
        assertEquals(count, lottos.size, "[ERROR]: Generated lotto count should match the requested count.")
    }

    @Test
    fun `givenGeneratedLottos_whenCheckingEachLotto_thenEachLottoHasExactly6Numbers`() {
        // given
        val count = 10
        val lottos = GenerateLottos.generate(count)

        // then
        lottos.forEach { lotto ->
            val numbers = lotto.getNumbers()
            assertEquals(6, numbers.size, "[ERROR]: Each lotto must contain exactly 6 numbers.")
        }
    }

    @Test
    fun `givenGeneratedLottos_whenCheckingEachLotto_thenNoDuplicateNumbersInEachLotto`() {
        // given
        val count = 10
        val lottos = GenerateLottos.generate(count)

        // then
        lottos.forEach { lotto ->
            val numbers = lotto.getNumbers()
            assertEquals(numbers.size, numbers.toSet().size, "[ERROR]: Lotto numbers must be unique.")
        }
    }

    @Test
    fun `givenGeneratedLottos_whenCheckingEachLotto_thenInRange1to45`() {
        // given
        val count = 10
        val lottos = GenerateLottos.generate(count)

        // then
        lottos.forEach { lotto ->
            lotto.getNumbers().forEach { number ->
                assertTrue(number in 1..45, "[ERROR]: Each lotto number must be between 1 and 45.")
            }
        }
    }
}