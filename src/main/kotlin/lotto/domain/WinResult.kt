package lotto.domain

class WinResult(
    private val result: MutableMap<Rank, Int> = initializeResult()
) {
    fun updateResult(rank: Rank) {
        result[rank] = result.getOrDefault(rank, 0) + 1
    }

    fun getResult(): Map<Rank, Int> = result.toMap()

    companion object {
        private fun initializeResult(): MutableMap<Rank, Int> {
            return Rank.entries.associateWith { 0 }.toMutableMap()
        }
    }
}
