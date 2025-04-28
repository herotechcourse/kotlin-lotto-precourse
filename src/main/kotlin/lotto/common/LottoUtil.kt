package lotto.common

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.model.Prize
import lotto.model.Winner

object LottoUtil {
    private const val MIN = 1
    private const val MAX = 45
    private const val COUNT = 6

    fun isValidLottoNumber(input: Int?): Boolean = input in MIN..MAX
    fun isValidLottoSize(input: List<Int?>): Boolean = input.size == COUNT

}