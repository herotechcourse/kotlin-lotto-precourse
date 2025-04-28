package lotto.domain

class LottoTicket private constructor(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == NUMBERS_COUNT) { "[ERROR] Lotto must contain exactly $NUMBERS_COUNT numbers." }
        require(numbers.distinct().size == NUMBERS_COUNT) { "[ERROR] Lotto numbers must be unique." }
    }

    companion object {
        private const val NUMBERS_COUNT = 6

        fun from(numbers: List<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber.from(it) }.sortedBy { it.value })
        }

        fun generate(): LottoTicket {
            val numbers = camp.nextstep.edu.missionutils.Randoms
                .pickUniqueNumbersInRange(1, 45, NUMBERS_COUNT)
                .map { LottoNumber.from(it) }
                .sortedBy { it.value }
            return LottoTicket(numbers)
        }
    }

    fun countMatches(winningNumbers: List<LottoNumber>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun hasBonusNumber(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }

    override fun toString(): String = numbers.map { it.value }.toString()
} 