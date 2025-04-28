package lotto.domain

import lotto.LottoMachine
import lotto.constant.LottoConstants
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows

class LottoMachineTest {

    @Test
    fun `The lotto machine should generate the correct number of lottos based on the money paid`() {
        // given
        val money = 5000

        // when
        val lottoMachine = LottoMachine(money)

        // then
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(5)
    }

    @Test
    fun `The lotto machine should throw an exception when money is not divisible by the lotto price`() {
        // given
        val money = 5500

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            LottoMachine(money)
        }
    }

    @Test
    fun `The lotto machine should generate lottos with the correct number of numbers`() {
        // given
        val money = 10000

        // when
        val lottoMachine = LottoMachine(money)
        val lottos = lottoMachine.getLottos()

        // then
        assertThat(lottos).isNotEmpty
        lottos.forEach { lotto ->
            assertThat(lotto.getNumbers()).hasSize(LottoConstants.LOTTO_NUMBER_COUNT)
        }
    }

    @Test
    fun `The lotto machine should generate lottos with numbers in the valid range`() {
        // given
        val money = 10000

        // when
        val lottoMachine = LottoMachine(money)
        val lottos = lottoMachine.getLottos()

        // then
        assertThat(lottos).isNotEmpty
        lottos.forEach { lotto ->
            assertThat(lotto.getNumbers()).allSatisfy { number ->
                assertThat(number).isBetween(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER)
            }
        }
    }

    @Test
    fun `The lotto machine should generate lottos with no duplicate numbers`() {
        // given
        val money = 10000

        // when
        val lottoMachine = LottoMachine(money)
        val lottos = lottoMachine.getLottos()

        // then
        assertThat(lottos).isNotEmpty
        lottos.forEach { lotto ->
            val numbers = lotto.getNumbers()
            assertThat(numbers).hasSize(LottoConstants.LOTTO_NUMBER_COUNT)
            assertThat(numbers).doesNotHaveDuplicates()
        }
    }

    @Test
    fun `The lotto machine should generate lottos with numbers in ascending order`() {
        // given
        val money = 10000

        // when
        val lottoMachine = LottoMachine(money)
        val lottos = lottoMachine.getLottos()

        // then
        assertThat(lottos).isNotEmpty
        lottos.forEach { lotto ->
            val numbers = lotto.getNumbers()
            assertThat(numbers).isSorted()
        }
    }

    @Test
    fun `The lotto machine should return all generated lottos when getLottos is called`() {
        // given
        val money = 3000

        // when
        val lottoMachine = LottoMachine(money)
        val lottos = lottoMachine.getLottos()

        // then
        assertThat(lottos).hasSize(3)
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(lottos.size)
    }

    @Test
    fun `The lotto machine should return zero lottos when money is zero`() {
        // given
        val money = 0

        // when
        val lottoMachine = LottoMachine(money)

        // then
        assertThat(lottoMachine.getNumberOfLottos()).isEqualTo(0)
        assertThat(lottoMachine.getLottos()).isEmpty()
    }
}
