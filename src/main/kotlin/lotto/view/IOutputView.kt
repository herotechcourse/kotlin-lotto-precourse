package lotto.view

import lotto.domain.PrizeRank

interface IOutputView {
    fun printTickets(tickets: List<List<Int>>)
    fun printStatistics(statistics: Map<PrizeRank, Int>, returnRate: Double)
    fun printError(message: String)
}