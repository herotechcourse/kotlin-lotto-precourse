package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        InputValidator.validateWinningNumbers(numbers)
    }

    fun prize(winningNumbers: List<Int>, bonusNumbers: List<Int>) : Prize {
        val matches = this.numbers.intersect(winningNumbers)
        val bonusMatches = this.numbers.intersect(bonusNumbers)

        return Prize.CRITERIA.getOrDefault(Pair(matches.size, bonusMatches.size), Prize.CRITERIA.get(Pair(matches.size, -1)))!!
    }

    override fun toString() : String {
        return "[${this.numbers.joinToString(", ")}]"
    }

    companion object {
        fun generate() : Lotto {
            return Lotto(Randoms.pickUniqueNumbersInRange(const.MIN_LOTTO_NUMBER, const.MAX_LOTTO_NUMBER, const.NUMBER_OF_LOTTO_NUMBERS).sorted())
            //return Lotto(listOf(1, 2, 3, 4, 5, 6))
        }
    }
}

class LottoTickets(private val tickets: List<Lotto>) {
    val numberOfTickets: Int
        get() = this.tickets.size

    val amount : Int
        get() = this.tickets.size * const.TICKET_PRICE

    fun toStrings() : List<String> {
        return this.tickets.map { it.toString() }
    }

    fun prizes(winningNumbers: List<Int>, bonusNumbers: List<Int>) : Prizes {
        return Prizes(
            this.tickets.map { it.prize(winningNumbers, bonusNumbers) }
            .filter { it != Prize.NONE }
            .groupingBy { it }
            .eachCount()
            .toSortedMap(reverseOrder())
        )
    }

    companion object {
        fun generate(numberOfTickets: Int): LottoTickets {
            return LottoTickets(List<Lotto>(numberOfTickets) {
                Lotto.generate()
            })
        }
    }
}
