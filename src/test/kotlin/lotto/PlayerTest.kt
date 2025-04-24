package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PlayerTest {

    val player = Player(10000)

    @Test
    fun `Create ticket list with size equal to number of tickets`() {
       val result = player.tickets
        assertThat(result).hasSize(10)
    }
}