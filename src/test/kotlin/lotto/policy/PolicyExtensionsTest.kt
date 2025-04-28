import lotto.error.BonusError
import lotto.error.ParseError
import lotto.error.PurchaseError
import lotto.error.WinningError
import lotto.policy.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PolicyValidationTest {

	@Test
	fun `should return error when amount is less than ticket price`() {
		val actual = 500L.isAtLeastTicketPrice()
		assertThat(actual).isEqualTo(PurchaseError.CANNOT_AFFORD_TICKET)
	}

	@Test
	fun `should return error when amount is not divisible by ticket price`() {
		val actual = 13500L.isDivisibleByTicketPrice()
		assertThat(actual).isEqualTo(PurchaseError.NOT_DIVISIBLE_BY_TICKET_PRICE)
	}

	@Test
	fun `should return error when string contains non-digit characters`() {
		val actual = "123a45".containsOnlyDigits()
		assertThat(actual).isEqualTo(ParseError.INVALID_FORMAT)
	}

	@Test
	fun `should return error when list of strings contains non-numeric value`() {
		val actual = listOf("1", "2", "abc", "4").containsOnlyNumeric()
		assertThat(actual).isEqualTo(ParseError.INVALID_FORMAT)
	}

	@Test
	fun `should return error when list of ints does not have valid size`() {
		val actual = listOf(1, 2, 3, 4, 5).hasValidSize()
		assertThat(actual).isEqualTo(WinningError.INVALID_SIZE)
	}

	@Test
	fun `should return error when list of ints has duplicates`() {
		val actual = listOf(1, 2, 3, 3, 4, 5).hasNoDuplicates()
		assertThat(actual).isEqualTo(WinningError.DUPLICATE_NUMBER)
	}

	@Test
	fun `should return error when list of ints is out of valid range`() {
		val actual = listOf(0, 2, 3, 4, 5, 6).isInRange()
		assertThat(actual).isEqualTo(WinningError.NOT_IN_RANGE)
	}

	@Test
	fun `should return error when bonus number is out of valid range`() {
		val actual = 50.isInRange()
		assertThat(actual).isEqualTo(BonusError.NOT_IN_RANGE)
	}

	@Test
	fun `should return error when bonus number is in winning numbers`() {
		val actual = 5.doesNotOverlapWithWinningNumbers(listOf(1, 2, 3, 4, 5, 6))
		assertThat(actual).isEqualTo(BonusError.DUPLICATE_NUMBER)
	}
}