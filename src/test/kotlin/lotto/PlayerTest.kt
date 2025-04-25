package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PlayerTest {
    @ParameterizedTest
    @ValueSource(ints = [100, 999, -3, 0])
    fun `throws an exception when amount is less than 1000`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Player(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1_000_001, 9_999_999, Int.MAX_VALUE])
    fun `throws an exception when amount is more than 100000`(input: Int) {
        assertThrows<IllegalArgumentException> {
            Player(input)
        }
    }

    @Test
    fun `Create ticket list with size equal to number of tickets`() {
        val player = Player(10000)
        val result = player.tickets
        assertThat(result).hasSize(10)
    }
}