package lotto

import lotto.config.bonusMap
import lotto.config.prizeMap


fun increasePrize(matches: Int, bonus: Boolean): Int {
    var prize: Int? = null

    if (bonus) {
        prize = bonusMap[matches]
    }

    if (prize == null) {
        prize = prizeMap[matches]
    }

    return prize ?: 0
}