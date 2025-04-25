package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Lotto numbers must be unique." }
        for (i in numbers) {
            if (i !in 1..45) throw IllegalArgumentException("[ERROR]Lotto numbers must be between 1 and 45.")
        }
    }
    fun numberOfMatches(ticket: List<Int>):Int = 6 - (numbers - ticket.toSet()).size
    fun bonusRepeatsNumber(bonus: Int): Boolean = numbers.contains(bonus)
}
