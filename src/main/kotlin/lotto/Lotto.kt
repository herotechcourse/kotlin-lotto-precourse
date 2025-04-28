package lotto
import lotto.support.*

class Lotto(private val numbers: List<Int>) {
    var matchCount: Int = 0
        private set
    var bonusMatched: Boolean = false
        private set
    var rank: Rank? = null
        private set

    init {
        require(numbers.size == TICKET_NUMBERS_COUNT) { Message.ERROR_LOTTO_NUMBERS_COUNT }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun settMatchCount(points: Int) {
        matchCount = points
    }

    fun markBonusMatched() {
        bonusMatched = true
    }

    fun getNumbers():List<Int> {
        return (numbers)
    }

    fun setRank(rank: Rank) {
        this.rank = rank
    }
}
