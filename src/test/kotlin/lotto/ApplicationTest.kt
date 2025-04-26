package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class ApplicationTest : NsTest() {

    @Test
    fun `feature test`() {
        // Read the test data from 'test_data.txt' file as a single string
        val input = readTestData("test_data.txt")

        // Set input from the file
        MockInputView.setInput(input)

        assertRandomUniqueNumbersInRangeTest(
            {
                run()  // This will now read from the simulated input
                assertThat(output()).contains(
                    "You have purchased 8 tickets.",
                    "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]",
                    "3 Matches (5,000 KRW) – 1 tickets",
                    "4 Matches (50,000 KRW) – 0 tickets",
                    "5 Matches (1,500,000 KRW) – 0 tickets",
                    "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
                    "6 Matches (2,000,000,000 KRW) – 0 tickets",
                    "Total return rate is 62.5%."
                )
            },
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45)
        )
    }

    @Test
    fun `exception test`() {
        val input = "1000j\n"
        MockInputView.setInput(input)  // Simulate invalid input

        assertSimpleTest {
            runException("1000j")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main() // Your main function that starts the application
    }

    // Function to read data from test_data.txt
    private fun readTestData(filePath: String): String {
        val file = File("src/test/resources/$filePath")
        return file.readText()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}

object MockInputView {
    private var inputIterator: Iterator<String>? = null

    // This method will simulate setting up the input
    fun setInput(input: String) {
        inputIterator = input.lineSequence().iterator()
        camp.nextstep.edu.missionutils.Console.readLine = {
            if (inputIterator?.hasNext() == true) inputIterator!!.next()
            else throw NoSuchElementException("No more input available")
        }
    }
}
