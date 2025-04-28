package prize

val prizeByRank: Array<Prize> = arrayOf(
    Prize(0, false, 0),
    Prize(6, false, 2_000_000_000),
    Prize(5, true, 30_000_000),
    Prize(5, false, 1_500_000),
    Prize(4, false, 50_000),
    Prize(3, false, 5_000)
)

val prizeByKey: Map<Int, Prize> = mapOf(
    6 to prizeByRank[1],
    -5 to prizeByRank[2],
    5 to prizeByRank[3],
    4 to prizeByRank[4],
    3 to prizeByRank[5]
)

fun getPrizeKeyByMatchesAndBonus(matches: Int, bonus: Boolean): Int{
    return if (bonus) -matches else matches
}