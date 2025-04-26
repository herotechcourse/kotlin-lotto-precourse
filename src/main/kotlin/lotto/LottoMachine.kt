package lotto

class LottoMachine {
    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        require(numberOfTickets > 0) { "[ERROR] Number of tickets must be positive." }
        return (1..numberOfTickets).map {
            val numbers = generateUniqueLottoNumbers()
            Lotto(numbers)
        }
    }

    private fun generateUniqueLottoNumbers(): List<Int> {
            return (1..45).shuffled().take(6).sorted()
        }
}