package lotto.support

object Validator {
    fun validatePurchaseAmount(amount: Int){
        require(amount >= TICKET_PRICE) { Message.ERROR_AMOUNT_TOO_SMALL }
        require(amount % TICKET_PRICE == 0) { Message.ERROR_AMOUNT_NOT_DIVISIBLE }
    }

    fun validateWinningTicket(ticket: List<Int>){
        require(ticket.size == TICKET_NUMBERS_COUNT) { Message.ERROR_WINNING_NUMBERS_COUNT}
        require(ticket.toSet().size == TICKET_NUMBERS_COUNT) { Message.ERROR_WINNING_NUMBERS_DUPLICATE }
        for (number in ticket){
            require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { Message.ERROR_WINNER_RANGE }}
    }

   fun validateBonusNumber(bonus: Int, ticket: List<Int>){
       require(bonus in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { Message.ERROR_BONUS_RANGE }
       require(bonus !in ticket) { Message.ERROR_BONUS_DUPLICATE }
   }
}