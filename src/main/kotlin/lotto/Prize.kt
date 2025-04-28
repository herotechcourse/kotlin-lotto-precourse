package lotto

/**
 * Enum class that holds the prize table of the lottery.
 *
 * @param matchCount: count of matching numbers
 * @param prize: the money to win
 * The enum has 5 prize ranks plus NONE for no prize. Enums are
 * fixed singletons - they are pre-declared constants. Since we
 * cannot create new instances, we need a factory function that
 * picks the according prize based on the matching numbers and
 * the bonus number.
 *
 * @see from: this factory function uses when to select the
 * prize rank. When is like a switch statement and here it is
 * used without a subject, because it uses more than one parameter
 * for the logic:
 * @param matchCount
 * @param hasBonus
 * Without a subject, it requires an else branch
 * in case no matches are found.
 * @returns an enum constant aka a singleton instance of the enum class
 * e.g. SECOND. It is a convention to name factories like "from", "select"
 * or "create".
 *
 * The factory is stored as a companion object. In Kotlin, companion objects
 * let you define class-level functions and properties. It is useful for
 * creating factory methods, holding constants, and accessing shared utilities.
 */
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
