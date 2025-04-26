package lotto.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Lotto

class OutputViewTest : NsTest() {
    override fun runMain() {}

    @Nested
    @DisplayName("printTicket Test")
    inner class PrintTicketTest {

        @Test
        @DisplayName("Should print the correct purchase message and tickets")
        fun testPrintTickets() {
            val tickets = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12))
            )

            OutputView.printTickets(tickets)

            assertThat(output()).contains("You have purchased 2 tickets")
            assertThat(output()).contains("[1, 2, 3, 4, 5, 6]")
            assertThat(output()).contains("[7, 8, 9, 10, 11, 12]")
        }
    }
}