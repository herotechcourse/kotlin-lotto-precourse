package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class LottoStoreTest {

    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val fixedMachine: LottoMachine = LottoMachine { lotto }
    private val sut = LottoStore(fixedMachine)

    @Test
    fun `returns correct number of Lotto tickets when amount is divisible by 1000`() {
        // Arrange
        val amount = Money(3000L)

        // Act
        val result: Lottos = sut.sell(amount)

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result.size()).isEqualTo(3)
            assertThat(result.getValues()).containsOnly(lotto)
        }
    }

}
