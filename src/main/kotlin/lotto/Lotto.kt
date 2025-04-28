package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LottoGenerator

class Lotto(private val numbers: List<Int> = LottoGenerator.generateLottoNumbers()) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> {
        return numbers
    }
}
