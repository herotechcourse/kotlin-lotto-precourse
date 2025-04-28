package lotto
import camp.nextstep.edu.missionutils.Randoms

class Tickets (
    val money:Int,
    private val pickNumbers: (min: Int, max: Int, count: Int) -> List<Int> =
        { min, max, count ->
            Randoms.pickUniqueNumbersInRange(min, max, count)
        }
) {
    val ticketCount:Int
    val lottos: List<Lotto>

    init {
        require(money % 1000 == 0) { "The purchase amount must be a multiple of 1000." }
        ticketCount = money / 1000

        lottos = List(ticketCount) { generateLotto() }
    }

    private fun generateLotto():Lotto{
        val numbers =pickNumbers(1, 45, 6)
        return Lotto(numbers)
    }
}