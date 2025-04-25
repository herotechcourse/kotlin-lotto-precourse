package lotto

const val BONUS: Int = 7

class Cashier (private val lotto: Lotto, private val bonusNumber: Int){
    private val register: MutableMap<Int, Int> =
        mutableMapOf(3 to 0, 4 to 0, 5 to 0, 6 to 0, BONUS to 0)
    fun checkWinningNumbers(tickets:List<List<Int>>): Map<Int, Int>{
        for (ticket in tickets ){
            var numberOfMatches = lotto.numberOfMatches(ticket)
            if (numberOfMatches == 5 && ticket.contains(bonusNumber))
                numberOfMatches = BONUS
            updateRegister(numberOfMatches)
        }
        return register
    }
    private fun updateRegister(numberOfMatches:Int){
        when(numberOfMatches){
            3 -> register[3] = register.getValue(3 ) + 1
            4 -> register[4] = register.getValue(4 ) + 1
            5 -> register[5] = register.getValue(5 ) + 1
            6 -> register[6] = register.getValue(6 ) + 1
            BONUS -> register[BONUS] = register.getValue(BONUS) + 1
        }
    }
}