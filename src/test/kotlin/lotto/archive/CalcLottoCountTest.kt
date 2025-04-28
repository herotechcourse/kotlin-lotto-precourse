package lotto.archive

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.api.Assertions.assertEquals

class CalcLottoCountTest {
    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "1400, 1",
        "2700, 2",
        "3000, 3",
        "5999, 5",
        "0, 0",
        "99999, 99",
        "100000, 100"
    )
    fun `givenVariousAmounts_whenCalculate_thenReturnCorrectCount`(amount: Int, expectedCount: Int) {
        val calcLottoCount = CalcLottoCount()
        val result = calcLottoCount.calculate(amount)
        assertEquals(expectedCount, result)
    }
}