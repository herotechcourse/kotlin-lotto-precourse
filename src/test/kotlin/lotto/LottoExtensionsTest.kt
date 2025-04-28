
package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoExtensionsTest {

    @Test
    @DisplayName("sortedNumbers returns numbers in ascending order")
    fun testSortedNumbers() {
        val ticket = Lotto(listOf(5, 2, 4, 1, 3, 6))
        assertThat(ticket.sortedNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    @DisplayName("countMatches returns correct match count")
    fun testCountMatches() {
        val winning = listOf(1, 2, 3, 4, 5, 6)
        val ticket  = Lotto(listOf(1, 2, 3, 7, 8, 9))
        assertThat(ticket.countMatches(winning)).isEqualTo(3)
    }

    @Test
    @DisplayName("hasNumber correctly detects presence")
    fun testHasNumber() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(ticket.hasNumber(3)).isTrue
        assertThat(ticket.hasNumber(7)).isFalse
    }
}
