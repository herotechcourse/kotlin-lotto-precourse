package lotto.error

import lotto.policy.GamePolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ErrorTypeExtensionTest {

	// winning numbers

	@Test
	fun `should return correct message for WINNING NOT_IN_RANGE`() {
		val error = WinningError.NOT_IN_RANGE.toMessage()
		assertThat(error)
			.contains("must be between")
			.contains("lotto numbers")
	}

	@Test
	fun `should return correct message for WINNING INVALID_SIZE`() {
		val error = WinningError.INVALID_SIZE.toMessage()
		assertThat(error)
			.contains("exactly")
			.contains(GamePolicy.LOTTO_SIZE.toString())
	}

	@Test
	fun `should return correct message for WINNING DUPLICATE_NUMBER`() {
		val error = WinningError.DUPLICATE_NUMBER.toMessage()
		assertThat(error)
			.contains("must not be duplicated")
			.contains("numbers")
	}

	// bonus number

	@Test
	fun `should return correct message for BONUS NOT_IN_RANGE`() {
		val error = BonusError.NOT_IN_RANGE.toMessage()
		assertThat(error)
			.contains("must be between")
			.contains("bonus number")
	}

	@Test
	fun `should return correct message for BONUS DUPLICATE_NUMBER`() {
		val error = BonusError.DUPLICATE_NUMBER.toMessage()
		assertThat(error)
			.contains("must not be duplicated")
			.contains("bonus")
	}

	@Test
	fun `should return correct message for PURCHASE NOT_DIVISIBLE_BY_TICKET_PRICE`() {
		val error = PurchaseError.NOT_DIVISIBLE_BY_TICKET_PRICE.toMessage()
		assertThat(error)
			.contains("must be divisible")
			.contains("${GamePolicy.TICKET_PRICE}")
	}

	@Test
	fun `should return correct message for PURCHASEINVALID_PURCHASE_AMOUNT`() {
		val error = PurchaseError.CANNOT_AFFORD_TICKET.toMessage()
		assertThat(error)
			.contains("purchase amount must be")
			.contains("${GamePolicy.TICKET_PRICE}")
	}
}
