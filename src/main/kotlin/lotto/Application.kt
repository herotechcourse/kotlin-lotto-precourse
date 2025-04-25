package lotto

fun main() {

    var inputView = InputView()

    for(ticket in inputView.tickets){
        val lotto = Lotto(ticket)
        lotto.start(ticket)
    }
}

