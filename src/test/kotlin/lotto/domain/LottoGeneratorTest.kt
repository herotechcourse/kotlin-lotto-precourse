package lotto.domain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoGeneratorTest {

    @Test
    fun `throws exception when money is less than 1000`() {
        assertThrows<IllegalArgumentException> {
            LottoGenerator.generateFrom(Money(999))
        }
    }

    @Test
    fun `generates correct number of tickets based on money`() {
        val money = Money(5000)
        val tickets = LottoGenerator.generateFrom(money)
        assertThat(tickets.size()).isEqualTo(5)
    }

    @Test
    fun `each generated ticket contains exactly 6 unique numbers between 1 and 45`() {
        val tickets = LottoGenerator.generateFrom(Money(1000)).getAll()
        val lotto = tickets.first()
        val numbers = lotto.getSortedNumbers()

        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet()).hasSize(6)
        assertThat(numbers.all { it in 1..45 }).isTrue()
    }
}