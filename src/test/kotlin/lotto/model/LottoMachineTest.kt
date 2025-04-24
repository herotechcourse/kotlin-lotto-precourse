package lotto.model

import lotto.Lotto
import lotto.fixture.FakeRandomNumbersGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {
    @Test
    fun `lotto machine has to make a random lottos according to purchase amount`() {
        // given
        val randomNumbersGenerator = FakeRandomNumbersGenerator(1, 2, 3, 4, 5, 6)
        val lottoMachine = LottoMachine(randomNumbersGenerator)

        // when
        val actual = lottoMachine.makeLottos(1000)

        // then
        val expected = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(actual).isEqualTo(listOf(expected))
    }

    @CsvSource(
        "1000, 1",
        "3001, 3",
        "1234, 1",
        "99999, 99",
        "1512315, 1512",
    )
    @ParameterizedTest
    fun `lotto machine has to make as many lotto tickets as the budget allows`(
        budget: Int,
        expectedCount: Int,
    ) {
        // given
        val randomNumbersGenerator = FakeRandomNumbersGenerator(1, 2, 3, 4, 5, 6)
        val lottoMachine = LottoMachine(randomNumbersGenerator)

        // when
        val actual = lottoMachine.makeLottos(budget).size

        // then
        assertThat(actual).isEqualTo(expectedCount)
    }
}
