package lotto.model

import lotto.utils.Constant.FIFTH_MATCH_COUNT
import lotto.utils.Constant.FIFTH_PRICE
import lotto.utils.Constant.FIRST_MATCH_COUNT
import lotto.utils.Constant.FIRST_PRICE
import lotto.utils.Constant.FOURTH_MATCH_COUNT
import lotto.utils.Constant.FOURTH_PRICE
import lotto.utils.Constant.SECOND_MATCH_COUNT
import lotto.utils.Constant.SECOND_PRICE
import lotto.utils.Constant.THIRD_MATCH_COUNT
import lotto.utils.Constant.THIRD_PRICE

enum class LottoPrice(val matchedCount: Int, val price: Int) {
    FIRST(FIRST_MATCH_COUNT, FIRST_PRICE),
    SECOND(SECOND_MATCH_COUNT, SECOND_PRICE),
    THIRD(THIRD_MATCH_COUNT, THIRD_PRICE),
    FOURTH(FOURTH_MATCH_COUNT, FOURTH_PRICE),
    FIFTH(FIFTH_MATCH_COUNT, FIFTH_PRICE);

    fun formattedPrice(): String = "%,d".format(price)
}
