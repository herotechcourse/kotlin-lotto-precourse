package lotto

class IssuedTicketsGenerator {

    companion object {

        fun of(issuedTicket: IssuedTicket) = List(issuedTicket.getCount()) {
            issuedTicket.getRandomUniqueNumbers()
        }
    }
}
