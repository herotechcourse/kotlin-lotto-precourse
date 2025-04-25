package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }
    fun start(numbers: List<Int>){
        validateNumberList()
        //findMatches()
    }

    private fun validateNumberList(){
        if (numbers.size != 6 || numbers.toSet().size != 6)
            throw IllegalArgumentException("[ERROR] Lotto must contain exactly 6 numbers.")
    }




    // TODO: Implement additional functions
}
