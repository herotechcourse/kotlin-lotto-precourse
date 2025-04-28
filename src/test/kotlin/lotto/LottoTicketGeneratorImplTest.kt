package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTicketGeneratorImplTest {

    private val randomNumbersGeneratorWrapper = object : RandomNumbersGeneratorWrapper {
        override fun generateRandomNumbersInRange(min: Int, max: Int, count: Int): List<Int> {
            return listOf(1, 2, 3, 4, 5, 6)
        }
    }

    private val lottoTicketGenerator: LottoTicketGenerator = LottoTicketGeneratorImpl(randomNumbersGeneratorWrapper)

    @Test
    fun `generateNumberOfTickets returns the correct number of tickets based on purchase amount`() {
        val purchaseAmount = 10000
        val expectedNumberOfTickets = 10

        val result = lottoTicketGenerator.generateNumberOfTickets(purchaseAmount)

        assertThat(result).isEqualTo(expectedNumberOfTickets)
    }

    @Test
    fun `generateTickets generates the correct number of tickets`() {
        val numberOfTickets = 5

        val result = lottoTicketGenerator.generateTickets(numberOfTickets)

        assertThat(result).hasSize(numberOfTickets)
    }

    @Test
    fun `generateTickets generates tickets with 6 numbers each`() {
        val numberOfTickets = 3

        val result = lottoTicketGenerator.generateTickets(numberOfTickets)

        assertThat(result).allSatisfy {
            assertThat(it.getTickets()).hasSize(6)
        }
    }

    @Test
    fun `generateTickets generates tickets with numbers between 1 and 45`() {
        val numberOfTickets = 2

        val result = lottoTicketGenerator.generateTickets(numberOfTickets)

        assertThat(result).allSatisfy {
            it.getTickets().forEach { number ->
                assertThat(number).isBetween(1, 45)
            }
        }
    }

    @Test
    fun `generateTickets throws an exception if ticket has more than 6 numbers`() {
        val faultyRandomNumbersGenerator = object : RandomNumbersGeneratorWrapper {
            override fun generateRandomNumbersInRange(min: Int, max: Int, count: Int): List<Int> {
                return listOf(1, 2, 3, 4, 5, 6, 7)
            }
        }

        val faultyLottoTicketGenerator: LottoTicketGenerator = LottoTicketGeneratorImpl(faultyRandomNumbersGenerator)

        assertThrows<IllegalArgumentException> {
            faultyLottoTicketGenerator.generateTickets(1)
        }
    }
}
