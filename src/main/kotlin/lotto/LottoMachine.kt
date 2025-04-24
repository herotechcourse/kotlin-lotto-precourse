package lotto
 
class LottoMachine()
{
    fun calcTicketNumber(purchaseAmount:Int):Int
    {
        return purchaseAmount/1000
    }

    fun issueTickets(ticketsCount:Int):MutableList<Lotto>
    {
        var tickets = mutableListOf<Lotto>()
        for(t in 1..ticketsCount) {
            val uniqueNumbers = Lotto.getUniqueNumbers() 
            var ticket = Lotto(uniqueNumbers)
            tickets.add(ticket)
        }
        return tickets
    }
}