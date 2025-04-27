package lotto.model

const val LOTTO_NUMBER_START = 1
const val LOTTO_NUMBER_END = 45
const val LOTTO_NUMBER_COUNT = 6

enum class LottoRank(val prize: Int, val comment: String) {
    FIRST(2_000_000_000, "6 Matches"),
    SECOND(30_000_000, "5 Matches + Bonus Ball"),
    THIRD(1_500_000, "5 Matches"),
    FOURTH(50_000, "4 Matches"),
    FIFTH(5_000, "3 Matches"),
}
