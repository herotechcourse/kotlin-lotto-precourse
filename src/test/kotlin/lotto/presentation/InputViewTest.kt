package lotto.presentation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest {
    @Test
    fun `readPurchaseAmount retries then succeeds`() {
        // 입력 시퀀스를 iterator로 준비
        val inputs = listOf("abc", "1500", "2000").iterator()

        // reader 함수: iterator에서 next() 호출
        val stubReader = { inputs.next() }

        // 실제로는 Console.readLine() 대신 stubReader를 쓰도록
        val result = InputView.readPurchaseAmount(stubReader)

        assertThat(result.amount).isEqualTo(2000)
    }

    @Test
    fun `readWinningNumbers retries then succeeds`() {
        // given
        val inputs = listOf(
            "1,2,3",            // invalid token count
            "1,a,3,4,5,6",      // non-numeric input
            "1, 2, 3, 4, 5, 6"  // valid input
        ).iterator()
        val stubReader = { inputs.next() }

        // when
        val winningNumbers = InputView.readWinningNumbers(stubReader)

        // then
        assertThat(winningNumbers.numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `readBonusNumber retries then succeeds`() {
        // given
        val inputs = listOf(
            "0",    // out of range
            "abc",  // non-numeric input
            "7"     // valid input
        ).iterator()
        val stubReader = { inputs.next() }

        // when
        val bonusNumber = InputView.readBonusNumber(stubReader)

        // then
        assertThat(bonusNumber.number).isEqualTo(7)
    }
}
