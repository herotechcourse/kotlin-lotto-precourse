package view

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InputViewTest : NsTest() {
    @Test
    fun `test retry`() {
        run("", "abc", "2000")
        val occurrences = output().split("Please enter the purchase amount.").size - 1
        assertTrue(occurrences == 3)
    }

    override fun runMain() {
        InputView.readPurchaseAmount()
    }
}