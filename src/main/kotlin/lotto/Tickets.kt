package lotto
import camp.nextstep.edu.missionutils.Randoms

class Tickets (val money:Int){
    val ticketCount:Int
    val lottos: List<Lotto>

    init {
        require(money % 1000 == 0) { "The purchase amount must be a multiple of 1000." }
        ticketCount = money / 1000

        lottos = List(ticketCount) { generateLotto() }
    }

    private fun generateLotto():Lotto{
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}