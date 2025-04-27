package lotto

import lotto.Consts.END_NUMBER
import lotto.Consts.START_NUMBER

interface Validator {

    fun validateInRange(number: Int) {
        require(number in START_NUMBER..END_NUMBER) {
            "Lotto number '$number' must be between $START_NUMBER and $END_NUMBER."
        }
    }
}
