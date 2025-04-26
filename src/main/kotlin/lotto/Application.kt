package lotto

fun main() {
    val inputView = InputView()
    val validator = Validator()
    var validPurchaseAmount: Int? = null
    while (true) {
        try {
            var purchaseAmount = inputView.read("Please enter the purchase amount.")
            validPurchaseAmount = validator.isPurchaseAmountValid(purchaseAmount)
            break
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }
    }
    val numberOfTickets = calculateNumberOfTickets(validPurchaseAmount!!)
    val lottoGenerator = LottoGenerator()
    var purchasedTickets = lottoGenerator.getTickets(numberOfTickets)
//    for (ticket in purchasedTickets)
//    {
//        ticket.printLottoTicket()
//    }
}
fun calculateNumberOfTickets(money: Int): Int
{
    var numberOfTickets = money / 1000
    return numberOfTickets
}
