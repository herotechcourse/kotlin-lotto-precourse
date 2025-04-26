package lotto

class LottoResultAnalyzer {

    fun analyze(lottos: List<Lotto>, lottoEvaluator: LottoEvaluator): List<LottoResultType> {
        val lottoResultTypes = mutableListOf<LottoResultType>()

        for (lotto in lottos) {
            lottoResultTypes.add(lotto.matchLotto(lottoEvaluator))
        }

        return lottoResultTypes
    }

}