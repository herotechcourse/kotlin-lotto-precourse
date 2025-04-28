package lotto.util

import camp.nextstep.edu.missionutils.Randoms

/**
 * Default generator using MissionUtils.pickUniqueNumbersInRange.
 */
class DefaultNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> =
        Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
