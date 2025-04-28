package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.Config

/**
 * Default generator using MissionUtils.pickUniqueNumbersInRange.
 */
class DefaultINumberGenerator : INumberGenerator {
    override fun generate(): List<Int> =
        Randoms.pickUniqueNumbersInRange(Config.LOTTO_MIN_NUMBER, Config.LOTTO_MAX_NUMBER, Config.NUMBERS_PER_TICKET)
}
