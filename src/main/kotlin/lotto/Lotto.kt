package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size==6){"[ERROR] Lotto numbers must not contain duplicate numbers."}
        numbers.forEach{number->
            require(number in 1..45){"[ERROR] Lotto numbers must be between 1 and 45."}
        }
    }

    // TODO: Implement additional functions
}
