package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputHandlerTest {

    @Test
    @DisplayName("When input is String, it must be parsed to Int")
    fun readPurchaseAmount() {
        // given
        val inputHandler = InputHandler()
        val fakeInput = { "5000" }

        // when
        val result = inputHandler.readPurchaseAmount(fakeInput)

        // then
        assertEquals(5000, result)
    }
}
