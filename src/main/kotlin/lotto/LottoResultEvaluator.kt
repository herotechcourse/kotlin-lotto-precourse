
package lotto

class LottoResultEvaluator {

    fun evaluate(ticket: Lotto, winning: List<Int>, bonus: Int): LottoRank {
        val matches  = ticket.countMatches(winning)    // extension 함수 이용
        val bonusHit = ticket.hasNumber(bonus)        // extension 함수 이용
        return LottoRank.of(matches, bonusHit)
    }
}
