package lotto.domain

import lotto.Lotto

class ResultCalculator (
  private val winningNumbers: Set<Int>,
  private val bonusNumber:Int
){
  fun calculate(tickets : List<Lotto>):Map<Rank,Int>{

    val result = mutableMapOf<Rank, Int>().withDefault { 0 }

    tickets.forEach{ ticket ->
      val matchNumbers = ticket.getNumbers().count{it in winningNumbers}

      val rank = when{
        matchNumbers ==6 -> Rank.FIFTH
        matchNumbers ==5 && bonusNumber in ticket.getNumbers() -> Rank.SECOND
        matchNumbers ==5 -> Rank.THIRD
        matchNumbers ==4 -> Rank.FOURTH
        matchNumbers ==3 -> Rank.FIFTH
        else -> Rank.NONE
      }
      result[rank] = result.getValue(rank)+1
    }
    return result
  }
}