package lotto

import camp.nextstep.edu.missionutils.Console

class Lotto(private val numbers: List<Int>) {
    init {

        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        if (numbers.any{ it == null || it < 0 }) println("[ERROR] Please enter the correct numbers between 1 to 45.")
        if (inputBonus == null || numbers.contains(inputBonus)) println("[ERROR] Please enter a separate bonus number between 1 to 45.")
    }

}
