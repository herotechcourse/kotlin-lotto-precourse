package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }){ "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getLottoNumber(): List<Int> {
        return numbers;
    }

    fun containsNumber(number: Int): Boolean{
        return numbers.contains(number)
    }

    fun countMatchingNumbers(anotherTicket : Lotto): Int {
        return numbers.count { it in anotherTicket.getLottoNumber() }
    }
}
