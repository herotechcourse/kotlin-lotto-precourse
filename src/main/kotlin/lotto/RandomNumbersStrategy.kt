package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersStrategy : GenerateStrategy {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}
