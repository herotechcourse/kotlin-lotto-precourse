package lotto.error

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ExceptionHandlerTest {

	@Test
	fun `should throw RetryInputException when error is Winning NOT_IN_RANGE`() {
		assertThrows<RetryInputException> {
			ExceptionHandler.throwIf(WinningError.NOT_IN_RANGE)
		}
	}

	@Test
	fun `should not throw exception when error is Common NON_ERROR`() {
		assertDoesNotThrow {
			ExceptionHandler.throwIf(Common.NON_ERROR)
		}
	}
}

