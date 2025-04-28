package lotto

import lotto.error.isStatusFailure
import lotto.error.isStatusSuccess
import lotto.policy.hasNoDuplicates
import lotto.policy.hasValidSize
import lotto.policy.isInRange
import lotto.policy.isSorted

class Lotto(private val numbers: List<Int>) {
	init {
		require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
		validateNumbers(numbers)
	}

	fun display() {
		println(numbers.joinToString(prefix = "[", postfix = "]"))
	}

	fun countMatched(winningNumbers: List<Int>): Int {
		return numbers.count { it in winningNumbers }
	}

	fun contains(bonusNumber: Int): Boolean {
		return numbers.contains(bonusNumber)
	}

	companion object {
		private fun validateNumbers(numbers: List<Int>) {
			val error = listOf(
				numbers.hasValidSize(),
				numbers.hasNoDuplicates(),
				numbers.isInRange()
			).firstOrNull { it.isStatusFailure() }
			require(error == null) { "Lotto validation failed" }
			require(numbers.isSorted().isStatusSuccess()) { "Lotto numbers must be sorted in ascending order" }
		}
	}
}