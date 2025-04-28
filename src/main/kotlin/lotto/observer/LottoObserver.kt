package lotto.observer

class LottoObserver(private val listeners: MutableList<ILottoListener> = mutableListOf()) : ILottoObserver {
    init {
        listeners.add(ConsoleListener())
    }

    override fun println(message: Any?) {
        listeners.forEach { it.notify(message) }
    }
}