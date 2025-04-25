package lotto.domain

data class LottoResultLine(
    val description: String,
    val count: Int
) {
    override fun toString(): String = "$description – $count tickets"
}
