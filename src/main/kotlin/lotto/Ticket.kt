package lotto

class Ticket(
    numbers: List<Int>
) {
    private val lotto: Lotto = Lotto(numbers.sorted())

    fun getNumbers(): List<Int> {
        return lotto.getNumbers().sorted()
    }
}