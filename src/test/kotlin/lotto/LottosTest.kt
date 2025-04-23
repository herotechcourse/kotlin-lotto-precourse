package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class LottosTest {

    private val values = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(7, 8, 9, 10, 11, 12))
    )

    @Test
    fun `size returns the number of Lotto tickets`() {
        // Arrange
        val lottos = Lottos(values)

        // Act
        val size = lottos.size()

        // Assert
        assertThat(size).isEqualTo(values.size)
    }

    @Test
    fun `getValues returns a defensive copy of the internal list`() {
        // Arrange
        val lottos = Lottos(values)

        // Act
        val result = lottos.getValues()

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result).containsExactlyElementsOf(values)
            assertThat(result).isNotSameAs(values)
        }
    }

}
