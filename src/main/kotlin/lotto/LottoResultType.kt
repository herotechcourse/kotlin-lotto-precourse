package lotto

enum class LottoResultType(val value: Int) {

    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    NO_PRIZE(0);

    companion object {
        fun from(matchCount: Int, isBonusMatched: Boolean): LottoResultType =
            when {
                matchCount == 6 -> FIRST_PRIZE
                matchCount == 5 && isBonusMatched -> SECOND_PRIZE
                matchCount == 5 -> THIRD_PRIZE
                matchCount == 4 -> FOURTH_PRIZE
                matchCount == 3 -> FIFTH_PRIZE
                else -> NO_PRIZE
            }

        fun countResultType(lottoResultTypes: List<LottoResultType>, targetType: LottoResultType): Int {
            return lottoResultTypes.count { lottoResultType -> lottoResultType == targetType }
        }

        fun calculate(lottoResultTypes: List<LottoResultType>): Int {
            var totalValue = 0
            for (lottoResultType in lottoResultTypes) {
                totalValue += lottoResultType.value
            }
            return totalValue
        }

    }

}