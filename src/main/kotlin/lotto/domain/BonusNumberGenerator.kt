package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

interface BonusNumberGenerator {
    fun generate(lotto: Lotto): Int
}

class RandomBonusNumberGenerator : BonusNumberGenerator {
    override fun generate(lotto: Lotto): Int {
        val existing = lotto.numbers().toSet()
        while (true) {
            val number = Randoms.pickNumberInRange(1, 45)
            if (number !in existing) return number
        }
    }
}

