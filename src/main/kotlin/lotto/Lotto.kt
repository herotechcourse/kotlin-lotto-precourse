package lotto

private const val SIX_MATCHES_COUNT = 6
private const val FIVE_MATCHES_COUNT = 5
private const val FOUR_MATCHES_COUNT = 4
private const val THREE_MATCHES_COUNT = 3


class Lotto(private var numbers: List<Int>) {

    init {
        require(numbers.size == Input.LOTTO_MAX_SIZE) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Winning numbers must not contain duplicates." }
    }

    //4. Implement a function to compare and Check the tickets with winning numbers
    fun checkLottery(totalTicketList: MutableList<MutableList<Int>>, bonus: Int): MutableMap<LottoEnum, Int> {


        val resultCount = mutableMapOf<LottoEnum, Int>().withDefault { 0 }
        totalTicketList.forEach { ticket ->
            val matchCount = ticket.count { it in numbers }
            val hasBonus = bonus in ticket

            val result = when {
                matchCount == SIX_MATCHES_COUNT -> LottoEnum.SIX
                matchCount == FIVE_MATCHES_COUNT && hasBonus -> LottoEnum.FIVE_BONUS
                matchCount == FIVE_MATCHES_COUNT -> LottoEnum.FIVE
                matchCount == FOUR_MATCHES_COUNT -> LottoEnum.FOUR
                matchCount == THREE_MATCHES_COUNT -> LottoEnum.THREE
                else -> null
            }
            if (result != null) {
                resultCount[result] = resultCount.getValue(result) + 1
            }
        }
        return resultCount
    }

}
