package lotto.view

import lotto.domain.PrizeRank

/**
 * Abstraction for printing results and errors.
 */
interface IOutputView {


    /**
     * Prints the purchased tickets.
     *
     * @param tickets list of ticket number lists
     */
    fun printTickets(tickets: List<List<Int>>)

    /**
     * Prints winning statistics and return rate.
     *
     * @param resultCounts map of [PrizeRank] to count
     * @param returnRate profit rate as percentage
     */
    fun printStatistics(resultCounts: Map<PrizeRank, Int>, returnRate: Double)

    /**
     * Prints an error message.
     *
     * @param message the error detail
     */
    fun printError(message: String)
}
