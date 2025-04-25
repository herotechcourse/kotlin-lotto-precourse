package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

interface BonusNumberGenerator {
    fun generate(lotto: Lotto): Int
}

class RandomBonusNumberGenerator : BonusNumberGenerator {
    override fun generate(lotto: Lotto): Int {
        val existing = lotto.numbers().toSet()
        return generateUniqueBonus(existing)
    }

    private fun generateUniqueBonus(existing: Set<Int>): Int {
        val number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
        return generateUniqueBonusIfNotExisting(number, existing)
    }

    private fun generateUniqueBonusIfNotExisting(number: Int, existing: Set<Int>): Int {
        if (number !in existing) return number
        return generateUniqueBonus(existing)
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
