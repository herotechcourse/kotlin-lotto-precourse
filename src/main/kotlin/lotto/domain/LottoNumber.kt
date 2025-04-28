package lotto.domain

class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { 
            "[ERROR] Lotto number must be between $MIN_NUMBER and $MAX_NUMBER." 
        }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        fun from(value: Int): LottoNumber = LottoNumber(value)

        fun values(): List<LottoNumber> = (MIN_NUMBER..MAX_NUMBER).map { LottoNumber(it) }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LottoNumber) return false
        return value == other.value
    }

    override fun hashCode(): Int = value

    override fun toString(): String = value.toString()
} 