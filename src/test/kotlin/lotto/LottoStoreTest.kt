package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class LottoStoreTest {

    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val fixedMachine = object : LottoMachine {
        override fun issue(): Lotto = lotto
    }
    private val sut = LottoStore(fixedMachine)

    @Test
    fun `returns correct number of Lotto tickets when amount is divisible by 1000`() {
        // Arrange
        val amount = 3000

        // Act
        val result = sut.sell(amount)

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result.size()).isEqualTo(3)
            assertThat(result.getValues()).containsOnly(lotto)
        }
    }

    @Test
    fun `throws exception when amount is not divisible by 1000`() {
        // Arrange
        val invalidAmount = 2500

        // Act
        // Assert
        assertThatThrownBy { sut.sell(invalidAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

}
