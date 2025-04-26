package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "Lotto numbers must be unique." }
        require(numbers.filter { it in 1..45 }.size == 6) { "The numbers must be in the range 1 to 45" }
    }
}
