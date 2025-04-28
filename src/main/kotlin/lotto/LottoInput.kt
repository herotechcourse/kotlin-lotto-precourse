// src/main/kotlin/lotto/LottoInput.kt
package lotto

object LottoInput {


    fun parseWinningNumbers(raw: String): List<Int> {
        val numbers = raw.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numeric.") }
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(numbers.toSet().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
        return numbers
    }


    fun parseBonusNumber(raw: String, winning: List<Int>): Int {
        val bonus = raw.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be numeric.")
        require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonus !in winning) { "[ERROR] Bonus number must not duplicate winning numbers." }
        return bonus
    }
}
