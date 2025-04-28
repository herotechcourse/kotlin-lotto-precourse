package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are in the wrong range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 2, 1, 4, 5, 7))
        }
    }

    @Test
    fun `valid lotto numbers`() {
        assertThatNoException().isThrownBy {
            Lotto(listOf(45, 2, 1, 3, 5, 7))
        }
    }

    @ParameterizedTest (name = "{index}. bonus number of {0}")
    @ValueSource(strings = ["-1", "0", "46", "3", "200"])
    fun `invalid bonus number`(input: String) {
        assertThatNoException().isThrownBy {
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            assertThatIllegalArgumentException().isThrownBy {
                lotto.setBonusNumber(input.toInt())
            }
        }
    }

    @Test
    fun `valid bonus numbers`() {
        assertThatNoException().isThrownBy {
            Lotto(listOf(45, 2, 1, 3, 5, 7)).setBonusNumber(26)
        }
    }

    @Test
    fun `compare tickets and lotto numbers returns correct values`() {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val lotto = Lotto(winningNumbers)
        lotto.setBonusNumber(7)

        val tickets = listOf(
            Ticket(listOf(1,2,3,4,5,6)), // FIRST
            Ticket(listOf(1,2,3,4,5,6)), // FIRST
            Ticket(listOf(1,2,3,4,5,7)), // SECOND
            Ticket(listOf(1,2,3,4,5,8)), // THIRD
            Ticket(listOf(1,2,3,4,8,9)), // FOURTH
            Ticket(listOf(1,2,3,8,9,10)), // FIFTH
            Ticket(listOf(1,2,8,9,10,11)), // NONE
        )

        val prizeCount = lotto.compareTicketsAndLottoNumbers(tickets)

        assertThat(prizeCount[Prize.FIRST]).isEqualTo(2)
        assertThat(prizeCount[Prize.SECOND]).isEqualTo(1)
        assertThat(prizeCount[Prize.THIRD]).isEqualTo(1)
        assertThat(prizeCount[Prize.FOURTH]).isEqualTo(1)
        assertThat(prizeCount[Prize.FIFTH]).isEqualTo(1)
        assertThat(prizeCount[Prize.NONE]).isEqualTo(1)
    }

    @Test
    fun `calculate total prize returns correct value`() {
        val prizeCount = mapOf(
            Prize.FIRST to 1, // 2_000_000_000
            Prize.SECOND to 2, // 30_000_000
            Prize.THIRD to 3, // 1_500_000
            Prize.FOURTH to 0, // 50_000
            Prize.FIFTH to 2, // 5_000
            Prize.NONE to 5,
        )

        val lotto = Lotto(listOf(1,2,3,4,5,6))
        val totalPrize = lotto.calculateTotalPrize(prizeCount)

        val expectedPrice = 2_000_000_000 + 2 * 30_000_000 + 1_500_000 * 3 + 5_000 * 2
        assertThat(expectedPrice).isEqualTo(totalPrize)
    }
}
