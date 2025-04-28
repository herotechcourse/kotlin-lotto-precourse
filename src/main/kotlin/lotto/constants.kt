/**
 * constants
 */

 package lotto

 class const {
	 companion object {
		const val TICKET_PRICE: Int = 1000
		const val MIN_AMOUNT: Int = TICKET_PRICE
		const val MAX_AMOUNT: Int = (Int.MAX_VALUE / TICKET_PRICE) * TICKET_PRICE
 
		const val LOTTO_NUMBERS_DELIMITER: String = ","
		const val NUMBER_OF_LOTTO_NUMBERS: Int = 6
		const val NUMBER_OF_BONUS_NUMBERS: Int = 1
		const val MIN_LOTTO_NUMBER: Int = 1
		const val MAX_LOTTO_NUMBER: Int = 45
 
		const val ERROR_MESSAGE_PREFIX: String = "[ERROR] "
	 }
 }
  