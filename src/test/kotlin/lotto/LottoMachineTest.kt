package lotto

import lotto.domain.LottoMachine
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoMachineTest {
    @Test
    fun `valid purchase amount 2000`() {
        val machine = LottoMachine("2000")
        assertThat(machine.numberOfLottos).isEqualTo(2)
    }

    @Test
    fun `invalid non-divisible`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine("1500")
        }
    }

    @Test
    fun `invalid negative`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine("-10000")
        }
    }

    @Test
    fun `invalid zero`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine("0")
        }
    }

    @Test
    fun `invalid positive`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine("500")
        }
    }

}