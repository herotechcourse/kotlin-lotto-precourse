package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoErrorTest {
    @Test
    fun `get unlisted error message`() {
        assertSimpleTest {
            assertThat(LottoError.get("attribute", "NoSuchError")).isBlank()
        }
    }

    @Test
    fun `get listed error messages`() = errorMessages.forEach {
        val expectedMessage = "$ERROR_MESSAGE attribute ${errorMessages[it.key]}"
        assertSimpleTest {
            assertThat(LottoError.get("attribute", it.key)).isEqualTo(expectedMessage)
        }
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
        private val errorMessages: Map<String, String> = mapOf(
            "isEmpty" to "should not be empty",
            "notDigit" to "should include only digits",
            "%1000" to "should be divided by 1000 without remainder",
            "size<6" to "size less then 6",
            "notUnique" to "elements are not unique",
            "notInRange1-45" to "elements are not in range 1..45",
            "inWinningNumbers" to "match number in winning numbers",
        )
    }
}