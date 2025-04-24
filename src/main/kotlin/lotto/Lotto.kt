package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require( numbers.all{ it in 1..45}) {"[ERROR] Please enter the correct numbers between 1 to 45."}
    }

    // check each ticket
    fun matchedNumbersCount (inputWinningNumbers: List<Int>): Int{
        return numbers.count{ inputWinningNumbers.contains(it)}
    }

    fun includedBonusNumber (inputBonus: Int): Boolean{
        return numbers.contains(inputBonus)
    }

}
