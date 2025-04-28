import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `returns correct ticket count`() {
        val machine = LottoMachine(5000)
        assertThat(machine.tickets).hasSize(5)
    }

    @Test
    fun `throws on negative money`() {
        assertThrows(IllegalArgumentException::class.java) {
            LottoMachine(-1000)
        }
    }

    @Test
    fun `rank list has length seven`() {
        val machine = LottoMachine(2000)
        val ranks = machine.setAllRank(setOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(ranks).hasSize(7)
    }

    @Test
    fun `return rate is within valid range`() {
        val machine = LottoMachine(2000)
        machine.setAllRank(setOf(1, 2, 3, 4, 5, 6), 7)
        val rate = machine.calculateReturnRate()
        assertThat(rate).isGreaterThanOrEqualTo(0.0)
    }
}
