package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LottoGenerator
import lotto.validator.LottoValidator

class Lotto(private val numbers: List<Int> = LottoGenerator.generateLottoNumbers()) {
    private val sortedNumbers = numbers.sorted()
    init {
        LottoValidator.validate(sortedNumbers)
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> {
        return sortedNumbers
    }
}
