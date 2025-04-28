package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.policy.GamePolicy

/**
 * Utility for generating lotto numbers.
 *
 * @return Always returns a list of unique random numbers sorted in ascending order.
 */
object LottoNumbers {
	fun generate(): List<Int> {
		return Randoms.pickUniqueNumbersInRange(
			GamePolicy.LOTTO_MIN_NUMBER,
			GamePolicy.LOTTO_MAX_NUMBER,
			GamePolicy.LOTTO_SIZE
		).sorted()
	}
}
