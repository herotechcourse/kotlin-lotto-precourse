package lotto.domain

class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    init {
        require(number in MIN..MAX) {
            "[ERROR] Lotto number must be between $MIN and $MAX."
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number - other.number
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LottoNumber) return false
        return number == other.number
    }

    override fun hashCode(): Int = number.hashCode()

    override fun toString(): String = number.toString()

    companion object {
        const val MIN = 1
        const val MAX = 45
    }
}