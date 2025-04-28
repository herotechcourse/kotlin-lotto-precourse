package lotto

open class Lotto(paramNumbers: List<Int>) {
    val numbers:List<Int> = paramNumbers.sorted()

    val bitmask: Long

    init {
        require (numbers.size == 6) { "Lotto must contain exactly 6 numbers." }
        bitmask = createBitmask(paramNumbers)
    }

    private fun createBitmask(numbers: List<Int>):Long{
        var bitmask = 0L
        for(number in numbers){
            bitmask = bitmask or (1L shl number)
        }
        return bitmask
    }

}
