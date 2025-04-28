package lotto
import lotto.model.WinningNumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
class WinningNumberTest {

    @Test
    fun `should Throw Exception When WinningNumbers Are Not Six`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1,2,3,4,5),30)
        }
    }

    @Test
    fun `should Throw Exception When WinningNumbers Have Duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(listOf(1,2,3,4,5,5),30)        }
    }

}