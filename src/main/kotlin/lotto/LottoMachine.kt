package lotto

object LottoMachine {
    fun createTickets(count: Int): List<Lotto> {
        return List(count) { Lotto(generateUniqueNumbers()) }
    }

    private fun generateUniqueNumbers(): List<Int> {
        return (1..45).shuffled().take(6)
    }
}
