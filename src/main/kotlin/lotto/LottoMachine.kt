package lotto

class LottoMachine {
    fun generateTickets(count: Int): List<Lotto> {
        return List(count) {
            Lotto(generateRandomNumbers())
        }
    }

    private fun generateRandomNumbers(): List<Int> {
        return (1..45).shuffled().take(6)
    }
}