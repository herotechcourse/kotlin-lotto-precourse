package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }
    fun getNumbers(): List<Int> = numbers

    fun matchCount(winningNumbers: List<Int>) : Int{
        return numbers.intersect(winningNumbers.toSet()).size
    }
    fun isBonus(bonus:Int):Boolean {
        return numbers.contains(bonus)
    }
}

fun generateLotto() : Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    return Lotto(numbers)
}

enum class Prize(val matchCout: Int, val hasBonus:Boolean, val reward: Int){
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    compaion object {
        fun of(matchCount: Int, hasBonus: Boolean): Prize{
            return when {
                matchCount==6 -> FIRST
                matchCount==5 && hasBonus -> SECOND
                matchCount==5 -> THIRD
                matchCount==4 -> FOURH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }

}

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonus: Int
) {
    init {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(!numbers.contains(bonus)) { "[ERROR] Bonus number must not be among winning numbers." }
    }

    fun match(lotto: Lotto): Prize {
        val matchCount = lotto.matchCount(numbers)
        val hasBonus = lotto.containsBonus(bonus)
        return Prize.of(matchCount, hasBonus)
    }
}