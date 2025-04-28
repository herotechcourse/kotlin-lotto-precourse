package lotto.orchestrator


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LottoRankOrchestratorTest {

    private val originalIn = System.`in`
    private val originalOut = System.out
    private lateinit var outputCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputCaptor = ByteArrayOutputStream()
        System.setOut(PrintStream(outputCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        System.setOut(originalOut)
    }

    @Test
    fun `executeLotto should run end-to-end and print the expected sections`() {
        val userInput = listOf(
            "1000",
            "1,2,3,4,5,6",
            "7"
        ).joinToString(System.lineSeparator())
        System.setIn(ByteArrayInputStream(userInput.toByteArray()))

        LottoRankOrchestrator().executeLotto()
        val output = outputCaptor.toString()

        assertThat(output).contains("You have purchased 1 tickets.")
        assertThat(output).contains("Winning Statistics")
        assertThat(output).contains("---")
        assertThat(output).containsPattern("Total return rate is \\d+(\\.\\d+)?%\\.")
    }
}
