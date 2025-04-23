package lotto

class Lottos(private val values: List<Lotto>) {

    fun size(): Int = values.size

    fun getValues(): List<Lotto> = values.toList()

}
