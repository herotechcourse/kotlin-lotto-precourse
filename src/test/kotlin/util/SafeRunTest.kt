package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SafeRunTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()
    
    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }
    
    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }
    
    @Test
    fun `safeRun executes block without exception`() {

        var executed = false

        safeRun {
            executed = true
        }

        assertThat(executed).isTrue()
        assertThat(outputStreamCaptor.toString()).isEmpty()
    }
    
    @Test
    fun `safeRun catches IllegalArgumentException and prints error message`() {

        val errorMessage = "Test error message"

        safeRun {
            throw IllegalArgumentException(errorMessage)
        }

        assertThat(outputStreamCaptor.toString()).contains("[ERROR] $errorMessage")
    }
    
    @Test
    fun `safeRun uses default error message when exception message is null`() {

        safeRun {
            throw IllegalArgumentException()
        }

        assertThat(outputStreamCaptor.toString()).contains("[ERROR] An error has occurred.")
    }
}