package lotto.model

import lotto.LotteryConstants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    private val lottoGenerator = LottoGenerator()

    @Test
    fun `generates the correct number of tickets`() {
        val tickets = lottoGenerator.generate(5)

        assertThat(tickets).hasSize(5)
    }

    @Test
    fun `generates ticket with the correct number of numbers`() {
        val tickets = lottoGenerator.generate(5)

        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).hasSize(LotteryConstants.LOTTO_NUMBER_COUNT)
        }
    }

    @Test
    fun `generates tickets with numbers in the valid range`() {
        val tickets = lottoGenerator.generate(5)

        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).allSatisfy { number ->
                assertThat(number).isBetween(LotteryConstants.MIN_NUMBER, LotteryConstants.MAX_NUMBER)
            }
        }
    }

    @Test
    fun `generates tickets with unique numbers`() {
        val tickets = lottoGenerator.generate(5)

        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates()
        }
    }

    @RepeatedTest(5)
    fun `generates different tickets each time`() {
        val firstBatch = lottoGenerator.generate(5)
        val secondBatch = lottoGenerator.generate(5)

        val hasDifferentTickets = firstBatch.zip(secondBatch).any { (a, b) ->
            a.getNumbers().sorted() != b.getNumbers().sorted()
        }

        assertThat(hasDifferentTickets).isTrue()
    }

    @Test
    fun `generates zero tickets when count is zero`() {
        val tickets = lottoGenerator.generate(0)

        assertThat(tickets).isEmpty()
    }
}