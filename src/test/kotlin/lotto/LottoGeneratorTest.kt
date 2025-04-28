
package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    private fun getNumbers(ticket: Lotto): List<Int> {
        val field = Lotto::class.java.getDeclaredField("numbers")
        field.isAccessible = true
        @Suppress("UNCHECKED_CAST")
        return field.get(ticket) as List<Int>
    }

    @Test
    @DisplayName("generateOne() should create a valid ticket with 6 numbers via reflection")
    fun testGenerateOne() {
        val ticket = LottoGenerator().generateOne()
        val nums = getNumbers(ticket)

        assertThat(nums).hasSize(6)
        assertThat(nums).allSatisfy { n -> assertThat(n).isBetween(1, 45) }
        assertThat(nums.toSet()).hasSize(6)
        assertThat(nums).isSortedAccordingTo { a, b -> a.compareTo(b) }
    }

    @Test
    @DisplayName("generate(count) should create the requested number of tickets via reflection")
    fun testGenerateMultiple() {
        val count = 5
        val tickets = LottoGenerator().generate(count)

        assertThat(tickets).hasSize(count)
        tickets.forEach { ticket ->
            val nums = getNumbers(ticket)
            assertThat(nums).hasSize(6)
        }
    }
}
