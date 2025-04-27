package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "Lotto numbers must be in the range 1 to 45" }
    }

    fun contains(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun match(other: Lotto): Int {
        return numbers.toSet().intersect(other.numbers.toSet()).size
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
