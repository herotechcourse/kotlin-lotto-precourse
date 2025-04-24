package lotto

class Lotto(private val _numbers: List<Int>) {
    init {
        require(_numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(_numbers.toSet().size == _numbers.size) { "[ERROR] Lotto must contain unique numbers." }
        require(_numbers.all { it in 1..45 }) { "[ERROR] All numbers must be in the range of 1 to 45." }
    }

    val numbers get() = _numbers.toList()
}
