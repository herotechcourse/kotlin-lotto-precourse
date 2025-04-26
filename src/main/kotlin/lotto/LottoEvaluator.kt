package lotto

interface LottoEvaluator {
    fun evaluateLotto(lottoNumbers: List<Int>): LottoResultType
}