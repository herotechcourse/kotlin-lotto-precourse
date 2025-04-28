package lotto.view

import lotto.domain.WinningNumbers
import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class InputViewTest {
    private val originalIn = System.`in`

    @AfterEach
    fun restore() {
        System.setIn(originalIn)
        Console.close()
    }

    @Test
    fun readPurchaseAmount_valid_input() {
        System.setIn(ByteArrayInputStream("5000\n".toByteArray()))
        assertThat(InputView.readPurchaseAmount()).isEqualTo(5000)
    }

    @Test
    fun `readWinningNumbers valid input`() {
        System.setIn(ByteArrayInputStream("1,2,3,4,5,6\n7\n".toByteArray()))
        val wn = InputView.readWinningNumbers()
        assertThat(wn.mainNumbers()).containsExactly(1,2,3,4,5,6)
        assertThat(wn.bonusNumber()).isEqualTo(7)
    }
}
