package lotto

import lotto.util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "${Constants.ERROR_PREFIX} Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size==6){"${Constants.ERROR_PREFIX} Lotto numbers must not contain duplicate numbers."}
        numbers.forEach{number->
            require(number in 1..45){"${Constants.ERROR_PREFIX} Lotto numbers must be between 1 and 45."}
        }
    }

    // TODO: Implement additional functions
}
