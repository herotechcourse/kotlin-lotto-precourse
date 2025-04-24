package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(!numbers.groupingBy { it }.eachCount().any { it.value > 1 }) { "[ERROR] Lotto must not contain duplicate numbers." }
        require(numbers.all { it >= 1 && it <= 45 }) { "[ERROR] Numbers must be in the range from 1 to 45" }
    }

    // sort

    // compare

    // return

}
