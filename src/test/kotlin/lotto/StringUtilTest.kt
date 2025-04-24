package lotto

import lotto.StringUtil.toIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringUtilTest {

    @Test
    fun `string with comma to int list`() {
        val validator = Validator()

        val toIntList = "1,2,3,4,5,6".toIntList(validator)

        assertEquals(listOf(1, 2, 3, 4, 5, 6), toIntList)
    }
}
