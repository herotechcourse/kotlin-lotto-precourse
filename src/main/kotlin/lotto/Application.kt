package lotto
import lotto.InputValidation.AmountValidation
import camp.nextstep.edu.missionutils.Console
const val winning_numbers_size = 6
private val validator = AmountValidation()

fun main() {

    println("Purchase amount for lottery tickets: ")
    val amount = InputPurchaseAmount()
    val purchaseAmount = validator.NullCheckAmount(amount)
    validator.ValidateAmount(purchaseAmount)

    //println("Amount = $amount")
}

fun InputPurchaseAmount() : String{
    val amount = Console.readLine()
    return amount
}


