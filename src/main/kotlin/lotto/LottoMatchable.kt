package lotto

interface LottoMatchable {
    fun matchLotto(lottoEvaluator: LottoEvaluator): LottoResultType
}