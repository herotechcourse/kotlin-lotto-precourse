/**
 * Prize
 */

package lotto

enum class Prize(val amount: Int, val description: String) {
    RANK1(2_000_000_000, "6 Matches"),
    RANK2(30_000_000, "5 Matches + Bonus Ball"),
    RANK3(1_500_000, "5 Matches"),
    RANK4(50_000, "4 Matches"),
    RANK5(5_000, "3 Matches"),
    NONE(0, "");

    companion object {
        val CRITERIA = buildMap<Pair<Int, Int>, Prize> {
            put(Pair(0, -1), Prize.NONE)
            put(Pair(1, -1), Prize.NONE)
            put(Pair(2, -1), Prize.NONE)
            put(Pair(3, -1), Prize.RANK5)
            put(Pair(4, -1), Prize.RANK4)
            put(Pair(5, 0), Prize.RANK3)
            put(Pair(5, 1), Prize.RANK2)
            put(Pair(6, -1), Prize.RANK1)
        }
    }
}

class Prizes(private val prizes: Map<Prize, Int>) {
    fun descriptions(): List<String> {
        return Prize.CRITERIA
            .filter { it.value.amount > 0 }
            .map { entry ->
                val description = "${entry.value.description} (${"%,d".format(entry.value.amount)} KRW)"
                val numberOfTickets = this.prizes.getOrDefault(entry.value, 0)
                // val pluralSuffix = if (this.prizes.get(entry.value) == 1) "" else "s"
                val pluralSuffix = "s"
                "$description – $numberOfTickets ticket$pluralSuffix"
            }
    }

    fun total() : Int {
        var totalAmount = 0
        this.prizes.forEach { entry ->
            totalAmount += entry.key.amount * entry.value
        }
        return totalAmount
    }
}
