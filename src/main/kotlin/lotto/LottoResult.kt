package lotto

import java.util.Locale

class LottoResult {
    private var _winningBoard: MutableMap<Rank, Int> = mutableMapOf()
    val winningBoard: Map<Rank, Int>
        get() = _winningBoard

    init {
        Rank.entries.forEach { _winningBoard[it] = 0 }
    }

    fun add(rank: Rank) {
        _winningBoard[rank] = _winningBoard.getOrDefault(rank, 0) + 1
    }

    fun report(rank: Rank): String {
        if (rank.mustMatchBonus)
            return "${rank.matchCount} Matches + Bonus Ball (${formatOutput("%,d", rank.prize)} KRW) – ${_winningBoard[rank]} tickets"
        return "${rank.matchCount} Matches (${formatOutput("%,d", rank.prize)} KRW) – ${_winningBoard[rank]} tickets"
    }

    fun calculateProfit(): Double {
        return winningBoard.entries
            .sumOf { it.key.prize * it.value }
            .toDouble()
    }

    companion object {
        fun formatOutput(format: String, arg: Any, locale: Locale = Locale.US): String {
            val validatedArg = validateArg(arg)
            return String.format(locale, format, validatedArg)
        }

        private fun validateArg(arg: Any): Any {
            return when (arg) {
                is Int -> arg
                is Double -> arg
                else -> throw IllegalArgumentException("[ERROR] Only Int or Double allowed")
            }
        }
    }
}