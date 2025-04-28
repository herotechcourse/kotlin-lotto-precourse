package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val output = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(output))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `prints purchase ticket amounts`() {
        OutputView.printPurchasedTickets(5)
        assertThat(output.toString().trim())
            .isEqualTo("You have purchased 5 tickets.")
    }

    @Test
    fun `prints match result`() {
        OutputView.printWinningResult("3 Matches", 5000, 1)
        assertThat(output.toString().trim())
            .isEqualTo("3 Matches (5,000 KRW) – 1 tickets")
    }

    @Test
    fun `prints return rate`() {
        OutputView.printReturnRate(100.0)

        assertThat(output.toString().trim())
            .isEqualTo("Total return rate is 100.0%.")
    }
}