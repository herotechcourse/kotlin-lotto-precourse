package lotto.input

import lotto.BonusNumber
import lotto.Lotto
import lotto.PurchaseAmount
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class InputViewTest {

    private lateinit var inputView: InputView

    @BeforeEach
    fun setUp() {
        inputView = InputView()
    }

    @Test
    fun `should return valid purchase amount when input is correct`() {
        val purchaseAmount = 5000
        val amount = PurchaseAmount(purchaseAmount)
        assertThat(amount.getNumberOfTickets()).isEqualTo(5)
    }

    @Test
    fun `should throw exception if purchase amount is invalid`() {
        val invalidAmount = 5500
        val exception = assertThrows<IllegalArgumentException> {
            PurchaseAmount(invalidAmount)
        }
        assertThat(exception.message).isEqualTo("[ERROR] Amount must be a multiple of 1000")
    }

    @Test
    fun `should return valid lotto numbers when input is correct`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = Lotto(lottoNumbers)
        assertThat(winningLotto.getLottoNumber()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `should throw exception if lotto number input is invalid`() {
        val invalidNumbers = listOf(1, 1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            Lotto(invalidNumbers)
        }
    }

    @Test
    fun `should return valid bonus number when input is correct`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val bonus = BonusNumber(bonusNumber, winningLotto)
        assertThat(bonus.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `should throw exception if bonus number is invalid`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val invalidBonusNumber = 6
        assertThrows<IllegalArgumentException> {
            BonusNumber(invalidBonusNumber, winningLotto)
        }
    }
}
