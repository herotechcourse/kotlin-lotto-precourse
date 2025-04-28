package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LottoGenerator
import lotto.validator.LottoValidator

class Lotto(private val numbers: List<Int> = LottoGenerator.generateLottoNumbers()) {
    init {
        LottoValidator.validate(numbers)
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> {
        return numbers
    }
}
