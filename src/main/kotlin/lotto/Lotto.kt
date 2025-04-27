package lotto

enum class Prize (val index: Int, val amount: Int) {
    MATCHED3(0, 5000),
    MATCHED4(1, 50000),
    MATCHED5(2, 1500000),
    `MATCHED-BONUS`(3, 30000000),
    MATCHED6(4, 2000000000),
    NONE(5, 0)
}

class  Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto must not contain duplicates" }
    }

    fun displayNumbers() {
        println(numbers)
    }

    fun calculatePrize(winningNumbers: List<Int>, bonusNumber: Int): Prize {
        val matched = numbers.intersect(winningNumbers.toSet())

        if (matched.size == 5 && bonusNumber in numbers) {
            return Prize.`MATCHED-BONUS`
        }

        when (matched.size) {
            3 -> return Prize.MATCHED3
            4 -> return Prize.MATCHED4
            5 -> return Prize.MATCHED5
            6 -> return Prize.MATCHED6
        }

        return Prize.NONE
    }
}
