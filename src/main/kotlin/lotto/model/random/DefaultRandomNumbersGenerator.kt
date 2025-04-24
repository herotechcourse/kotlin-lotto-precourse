package lotto.model.random

import camp.nextstep.edu.missionutils.Randoms

class DefaultRandomNumbersGenerator: RandomNumbersGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
