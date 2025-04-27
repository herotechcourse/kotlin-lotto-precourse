package lotto.support

import lotto.support.Message

object Validator {
    private const val TICKET_PRICE= 1000
    private const val MAX_LOTTO_NUMBER = 45
    private const val MIN_LOTTO_NUMBER = 1

    fun validatePurchaseAmount(amount: Int){
        require(amount >= TICKET_PRICE) { Message.ERROR_AMOUNT_TOO_SMALL }
        require(amount % TICKET_PRICE == 0) { Message.ERROR_AMOUNT_NOT_DIVISIBLE }
    }

    fun validateWinningTicket(winner: List<Int>){
        for (number in winner)
            require(number <= MAX_LOTTO_NUMBER || number >= MIN_LOTTO_NUMBER) { Message.ERROR_WINNER_RANGE }
    }

   fun validateBonusNumber(number: Int){
       require(number <= MAX_LOTTO_NUMBER || number >= MIN_LOTTO_NUMBER) { Message.ERROR_BONUS_RANGE }
   }
}