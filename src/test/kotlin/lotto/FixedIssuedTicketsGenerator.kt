package lotto

object FixedIssuedTicketsGenerator {

    fun of(): List<List<Int>> {
        return listOf(
            listOf(8, 21, 23, 41, 42, 43),
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 22, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(3, 4, 5, 11, 22, 30),
            listOf(1, 3, 5, 14, 22, 45),
        )
    }
}
