package utils

import model.Prize
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.abs

class AccountantTest {
    @Test
    fun `should return expected return rate for wining 1st prize`() {
        val input1 = mapOf(
            Prize.FIFTH_PRIZE to 0,
            Prize.FORTH_PRIZE to 0,
            Prize.THIRD_PRIZE to 0,
            Prize.SECOND_PRIZE to 0,
            Prize.FIRST_PRIZE to 1
        )
        val ticketCount1 = 8
        val expectedRate1 = 25000000.0  // Use Double type for comparison
        val result1 = Accountant.analyse(input1, ticketCount1)

        // Define an acceptable difference (epsilon)
        val epsilon = 0.1

        assertTrue(abs(expectedRate1 - result1) < epsilon, "Expected $expectedRate1 but got $result1")
    }

    @Test
    fun `should return expected return rate for wining 2nd prize`() {
        val input1 = mapOf(
            Prize.FIFTH_PRIZE to 0,
            Prize.FORTH_PRIZE to 0,
            Prize.THIRD_PRIZE to 0,
            Prize.SECOND_PRIZE to 1,
            Prize.FIRST_PRIZE to 0
        )
        val ticketCount1 = 8
        val expectedRate1 = 375000.0  // Use Double type for comparison
        val result1 = Accountant.analyse(input1, ticketCount1)
        // Define an acceptable difference (epsilon)
        val epsilon = 0.1
        assertTrue(abs(expectedRate1 - result1) < epsilon, "Expected $expectedRate1 but got $result1")
    }

    @Test
    fun `should return expected return rate for wining 3rd prize`() {
        val input1 = mapOf(
            Prize.FIFTH_PRIZE to 0,
            Prize.FORTH_PRIZE to 0,
            Prize.THIRD_PRIZE to 1,
            Prize.SECOND_PRIZE to 0,
            Prize.FIRST_PRIZE to 0
        )
        val ticketCount1 = 8
        val expectedRate1 = 18750.0  // Use Double type for comparison
        val result1 = Accountant.analyse(input1, ticketCount1)

        // Define an acceptable difference (epsilon)
        val epsilon = 0.1

        assertTrue(abs(expectedRate1 - result1) < epsilon, "Expected $expectedRate1 but got $result1")
    }

    @Test
    fun `should return expected return rate for wining 4th prize`() {
        val input1 = mapOf(
            Prize.FIFTH_PRIZE to 0,
            Prize.FORTH_PRIZE to 1,
            Prize.THIRD_PRIZE to 0,
            Prize.SECOND_PRIZE to 0,
            Prize.FIRST_PRIZE to 0
        )
        val ticketCount1 = 8
        val expectedRate1 = 625.0  // Use Double type for comparison
        val result1 = Accountant.analyse(input1, ticketCount1)

        // Define an acceptable difference (epsilon)
        val epsilon = 0.1

        assertTrue(abs(expectedRate1 - result1) < epsilon, "Expected $expectedRate1 but got $result1")
    }

    @Test
    fun `should return expected return rate for wining 5th prize`() {
        val input1 = mapOf(
            Prize.FIFTH_PRIZE to 1,
            Prize.FORTH_PRIZE to 0,
            Prize.THIRD_PRIZE to 0,
            Prize.SECOND_PRIZE to 0,
            Prize.FIRST_PRIZE to 0
        )
        val ticketCount1 = 8
        val expectedRate1 = 62.5  // Use Double type for comparison
        val result1 = Accountant.analyse(input1, ticketCount1)

        // Define an acceptable difference (epsilon)
        val epsilon = 0.1

        assertTrue(abs(expectedRate1 - result1) < epsilon, "Expected $expectedRate1 but got $result1")
    }

    @Test
    fun `should return zero rate return when there is no winning ticket`(){
        val input1 = mapOf(
            Prize.FIFTH_PRIZE to 0,
            Prize.FORTH_PRIZE to 0,
            Prize.THIRD_PRIZE to 0,
            Prize.SECOND_PRIZE to 0,
            Prize.FIRST_PRIZE to 0
        )
        val ticketCount1 = 8
        val expectedRate1 = 0  // Use Double type for comparison
        val result1 = Accountant.analyse(input1, ticketCount1)

        // Define an acceptable difference (epsilon)
        val epsilon = 0.1

        assertTrue(abs(expectedRate1 - result1) < epsilon, "Expected $expectedRate1 but got $result1")
    }
}