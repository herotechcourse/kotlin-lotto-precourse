package lotto

object InputValidate {
    fun validateAmount(amount: String): Int{
        //to do
        return amount.toInt()
    }

    fun validateWinningNumber(winningNumber: String): List<Int>{
        // to do
        var winningNumber: List<Int> = listOf()

        return winningNumber
    }

    fun validateBonusNumber(bonusNumber: String, winningNumber: List<Int>): Int{
        // to do

        return bonusNumber.toInt()
    }

    fun validateTickets(tickets: MutableList<List<Int>>): List<List<Int>>{
        // to to
       val validateTickets: List<List<Int>> = tickets
        return validateTickets
    }


}