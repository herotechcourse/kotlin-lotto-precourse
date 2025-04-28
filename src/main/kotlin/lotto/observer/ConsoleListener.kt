package lotto.observer

class ConsoleListener: ILottoListener {
    override fun notify(message: Any?) {
        println(message)
    }
}