package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val fixedMachine: LottoMachine = LottoMachine { lotto }
    private val sut = LottoStore(fixedMachine)

    @Test
    fun `returns correct number of Lotto tickets when amount is divisible by 1000`() {
        // Arrange
        val amount = 3000L

        // Act
        val result: Lottos = sut.sell(amount)

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result.size()).isEqualTo(3)
            assertThat(result.getValues()).containsOnly(lotto)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "-1000, Money must not be negative.",
        "1500, Money must be divisible by",
    )
    fun `throws exception for invalid amounts`(amount: Long, message: String) {
        // Act
        // Assert
        assertThatThrownBy { sut.sell(amount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(message)
    }

}
