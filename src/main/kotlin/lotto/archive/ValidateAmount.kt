package lotto.archive

/**
 *  [ Test Scenarios ]
 *  (Invalid)
 *  1. Blank input
 *  2. Non-numeric input
 *  3. Leading zero input
 *  4. Too small input (Amount < 1000)
 *
 *  (Valid)
 *  5. Amount = 1000
 *  6. Amount < 1000
 *
 *  [ Background ]
 *  1. expression body
 *     Instead of using curly brackets { with return },
 *     using '=' to return the value directly.
 *     = Good for clean code.
 */
fun isEmpty(amount: String): Boolean = amount.isBlank()

fun isNonNumeric(amount: String): Boolean = amount.toIntOrNull() == null

fun isLeadingZero(amount: String): Boolean = amount.length > 1 && amount.startsWith("0")

/**
 *  Checks whether the input is less than 1000.
 *
 *  @param amount: The purchase amount from user.
 *  @return true: If input is convertible to (Int) and less than 1000.
 *
 *  [ Steps ]
 *  1. Try converting input type from string to int.
 *  2. If conversion succeeds(Not null), run let() // scope function.
 *  3. Inside let(): return (true), if value < 1000.
 *  4. else, return: false.
 *
 *  [ Background ]
 *  1. require()
 *      Throws an IllegalArgumentException, if the condition is not met.
 *      Cleaner code than directly inputting IllegalArgumentException.
 */
fun isTooSmall(amount: String): Boolean = amount.toIntOrNull()?.let { it < 1000 } ?: false

object ValidateAmount {
    fun validate(amount: String) {
        require(!isEmpty(amount)) { "Type of amount must be numeric." }
        require(!isNonNumeric(amount)) { "Type of amount must be numeric." }
        require(!isLeadingZero(amount)) { "Amount must not start with zero." }
        require(!isTooSmall(amount)) { "Amount must be at least 1,000." }
    }
}