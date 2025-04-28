package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {

    @Test
    @DisplayName("Create LottoTicket with valid purchase money")
    fun makeLottoTicket_validPurchaseMoney() {
        val purchaseMoney = "5000"

        val lottoTicket = LottoStore.makeLottoTicket(purchaseMoney)

        assertThat(lottoTicket).isNotNull
        assertThat(lottoTicket.getLottosCount()).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "a1w2", "qwer1234"])
    @DisplayName("Throw exception when purchase money is not a number")
    fun makeLottoTicket_invalidPurchaseMoneyNotNumber(purchaseMoney: String) {
        assertThatThrownBy { LottoStore.makeLottoTicket(purchaseMoney) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["12001", "4242", "1234"])
    @DisplayName("Throw exception when purchase money is not divisible by lotto price")
    fun makeLottoTicket_notDivisibleByLottoPrice(purchaseMoney: String) {
        assertThatThrownBy { LottoStore.makeLottoTicket(purchaseMoney) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
