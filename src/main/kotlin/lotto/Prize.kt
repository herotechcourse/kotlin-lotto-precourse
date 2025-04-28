package lotto

enum class Prize(val matchCount: Int, val prize: Int) {
    FIRST(6, 2000000000), // important: comma -> enums are a list of constants
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0); // important: semicolon here because of the factory function

    companion object Factory {
        fun from(matchCount: Int, hasBonus: Boolean): Prize = when {
            matchCount == 6 -> Prize.FIRST
            matchCount == 5 && hasBonus -> Prize.SECOND
            matchCount == 5 -> Prize.THIRD
            matchCount == 4 -> Prize.FOURTH
            matchCount == 3 -> Prize.FIFTH
            else -> NONE
        }
    }
}
