package lotto.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {

    @Test
    fun `throws exception for invalid purchase amount`() {
        val lottoMachine = LottoMachine()

        // Negative amount
        assertThrows<IllegalArgumentException> {
            lottoMachine.issue(-1000)
        }

        // Zero amount
        assertThrows<IllegalArgumentException> {
            lottoMachine.issue(0)
        }

        // Not divisible by 1000
        assertThrows<IllegalArgumentException> {
            lottoMachine.issue(1500)
        }
    }

    @Test
    fun `issues correct number of lottos for purchase amount`() {
        val lottoMachine = LottoMachine()

        // 1000 won = 1 lotto
        val lottos1 = lottoMachine.issue(1000)
        Assertions.assertThat(lottos1).hasSize(1)

        // 8000 won = 8 lottos
        val lottos2 = lottoMachine.issue(8000)
        Assertions.assertThat(lottos2).hasSize(8)
    }

    @Test
    fun `generates valid lotto numbers`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest(
            {
                val lottoMachine = LottoMachine()
                val lottos = lottoMachine.issue(1000)

                // Verify that the lotto is valid
                Assertions.assertThat(lottos).hasSize(1)
                val lotto = lottos[0]

                // Check that it has the expected numbers
                Assertions.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
            },
            listOf(1, 2, 3, 4, 5, 6)
        )
    }
}