package lotto

data class LottoNumber(val value: Int) {

    init {
        require(value in MIN_RANGE..MAX_RANGE) { NUMBER_OUT_OF_RANGE_ERROR }
    }

    companion object {
        const val MIN_RANGE: Int = 1
        const val MAX_RANGE: Int = 45

        const val NUMBER_OUT_OF_RANGE_ERROR: String = "[ERROR] Number must be between $MIN_RANGE and $MAX_RANGE"
    }
}
