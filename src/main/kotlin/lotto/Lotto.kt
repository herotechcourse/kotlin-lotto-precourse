package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    private val sortedNumbers = numbers.sorted()
    fun getNumbers(): List<Int> = sortedNumbers
}
//로또 번호의 유효성을 검증하고, 정렬된 번호 목록을 반환