package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}