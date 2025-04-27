package lotto.messages

enum class RankMessages(val message: String) {
    SECOND("5 Matches + Bonus Ball (%s KRW) – %d tickets"),
    GENERAL("%d Matches (%s KRW) – %d tickets");

    fun with(vararg args: Any): String {
        return message.format(*args)
    }
}