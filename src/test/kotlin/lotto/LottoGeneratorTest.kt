package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGeneratorTest {

    @Test
    fun `generated ticket contains exactly 6 numbers`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.createLottoTicket()

        assertThat(lotto.getNumbers()).hasSize(6)
    }

    @Test
    fun `numbers are sorted ascending`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.createLottoTicket()

        assertThat(lotto.getNumbers())
            .isEqualTo(lotto.getNumbers().sorted())
    }

    @Test
    fun `all numbers are between 1 and 45 inclusive`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.createLottoTicket()

        assertThat(lotto.getNumbers()).allSatisfy { number ->
            assertThat(number).isBetween(1, 45)
        }
    }

    @Test
    fun `numbers are unique`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.createLottoTicket()

        assertThat(lotto.getNumbers().distinct())
    }
}