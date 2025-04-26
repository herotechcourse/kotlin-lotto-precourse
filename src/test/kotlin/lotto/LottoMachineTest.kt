package lotto

import lotto.domain.LottoMachine
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoMachineTest {
    @Test
    fun `throws an exception when amount is less than ticket price`() {
        // Given
        val lottoMachine = LottoMachine()
        val amount = 500 // Less than 1000

        // When & Then
        assertThrows<IllegalArgumentException> {
            lottoMachine.buyLottos(amount)
        }
    }

    @Test
    fun `throws an exception when amount is not divisible by ticket price`() {
        // Given
        val lottoMachine = LottoMachine()
        val amount = 1500 // Not divisible by 1000

        // When & Then
        assertThrows<IllegalArgumentException> {
            lottoMachine.buyLottos(amount)
        }
    }

    @Test
    fun `returns correct number of lottos when amount is valid`() {
        // Given
        val lottoMachine = LottoMachine()
        val amount = 5000 // 5 tickets

        // When
        val lottos = lottoMachine.buyLottos(amount)

        // Then
        assertThat(lottos).hasSize(5)
    }

    @Test
    fun `each lotto has sorted numbers`() {
        // Given
        val lottoMachine = LottoMachine()

        // When
        val lottos = lottoMachine.buyLottos(1000)

        // Then
        lottos.forEach { lotto ->
            val numbers = lotto.toString().removeSurrounding("[", "]").split(", ").map { it.toInt() }
            assertThat(numbers).isEqualTo(numbers.sorted())
        }
    }
}