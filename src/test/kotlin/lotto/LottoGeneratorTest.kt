package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `should generate Lotto with 6 unique numbers`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val lotto = LottoGenerator().generateLotto()
                val numbers = lotto.getSortedNumbers()

                assertThat(numbers).hasSize(6)
                assertThat(numbers.toSet()).hasSize(6)
                assertThat(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }).isTrue
            },
            listOf(1, 2, 3, 4, 5, 6)
        )
    }
}