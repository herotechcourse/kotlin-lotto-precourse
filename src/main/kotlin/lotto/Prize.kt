package lotto

enum class Prize(val condition: String, val money: Int) {
    FIRST("6 Matches", 2_000_000_000),
    SECOND("5 Matches + Bonus Ball", 30_000_000),
    THIRD("5 Matches", 1_500_000),
    FOURTH("4 Matches", 50_000),
    FIFTH("3 Matches", 5_000);

    fun getFormattedMoney(): String {
        return String.format("%,d", money)
    }
}