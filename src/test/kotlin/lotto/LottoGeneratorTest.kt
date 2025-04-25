package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `throws error when amount is not divisible by 1000`() {
        assertThatThrownBy {
            LottoGenerator.generate(1550)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("divisible by 1,000")
    }

    @Test
    fun `generates correct number of tickets`() {
        val tickets = LottoGenerator.generate(5000)
        assertThat(tickets).hasSize(5)
    }

    @RepeatedTest(10) // run multiple times to test randomness
    fun `each generated ticket has 6 unique numbers between 1 and 45`() {
        val tickets = LottoGenerator.generate(5000)
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertThat(numbers).hasSize(6)
            assertThat(numbers.distinct()).hasSize(6)
            assertThat(numbers).allMatch { it in 1..45 }
        }
    }
}
