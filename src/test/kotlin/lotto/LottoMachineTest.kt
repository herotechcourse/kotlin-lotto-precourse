package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `throws an exception when price is incorrect`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine.purchaseLottos(150)
        }
    }

    @Test
    fun `return lottos matching for the price`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val lottos = LottoMachine.purchaseLottos(5000)
                assertEquals(
                    lottos.size,
                    5
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
        )
    }
}
