package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) {"[ERROR] Lotto numbers must be unique."}
        require(numbers.all {it in 1..45}) {"[ERROR] Lotto numbers must be between 1 and 45."}
    }

    //This function returns the numbers of the Lotto ticket
    fun getNumbers(): List<Int> = numbers

    //This function counts how many numbers from the Lotto match with the winning numbers
    fun matchCount(winningNumbers: List<Int>): Int = numbers.count { it in winningNumbers }

    // This function to check if a specific number is in the Lotto ticket
    fun contains(number: Int): Boolean = number in numbers

}
