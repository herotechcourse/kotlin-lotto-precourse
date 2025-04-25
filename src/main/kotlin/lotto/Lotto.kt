package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE) { "Lotto must contain exactly $SIZE numbers." }
        require(numbers.toSet().size == SIZE) { "Lotto numbers must be unique." }
        require(numbers.all { it in FIRST_NUM..LAST_NUM }) { "Lotto numbers must be in ${FIRST_NUM..LAST_NUM}" }
    }

    fun getLottoNumbers(): List<Int> = numbers

    companion object {
        private const val FIRST_NUM = 1
        private const val LAST_NUM = 45
        const val SIZE = 6
        const val COST = 1000

        fun getRandomLottoNumbers(): Lotto =
            Lotto(Randoms.pickUniqueNumbersInRange(FIRST_NUM, LAST_NUM, SIZE))
    }
}
