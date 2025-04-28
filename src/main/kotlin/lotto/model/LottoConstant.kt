package lotto.model

const val LOTTO_NUMBER_START = 1
const val LOTTO_NUMBER_END = 45
const val LOTTO_NUMBER_COUNT = 6

enum class LottoRank(val prize: Int, val comment: String) {
    FIFTH(5_000, "3 Matches"),
    FOURTH(50_000, "4 Matches"),
    THIRD(1_500_000, "5 Matches"),
    SECOND(30_000_000, "5 Matches + Bonus Ball"),
    FIRST(2_000_000_000, "6 Matches"),
}
