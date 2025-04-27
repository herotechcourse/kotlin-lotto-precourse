package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `test checkLottery for various match scenarios`() {
        val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        val totalTicketList = mutableListOf(
            mutableListOf(1, 2, 3, 4, 5, 6),
            mutableListOf(1, 2, 3, 4, 5, 7),
            mutableListOf(1, 2, 3, 4, 5, 6),
            mutableListOf(1, 2, 3, 4, 5, 8),
            mutableListOf(1, 2, 3, 4, 9, 10),
            mutableListOf(1, 2, 3, 7, 8, 9),
            mutableListOf(1, 2, 3, 4, 5, 6)
        )

        val bonus = 7
        val result = Lotto(numbers).checkLottery(totalTicketList, bonus)

        assertThat(result).containsExactlyInAnyOrderEntriesOf(
            mapOf(
                LottoEnum.SIX to 3,
                LottoEnum.FIVE to 1,
                LottoEnum.FIVE_BONUS to 1,
                LottoEnum.FOUR to 1,
                LottoEnum.THREE to 1
            )
        )
    }
}
