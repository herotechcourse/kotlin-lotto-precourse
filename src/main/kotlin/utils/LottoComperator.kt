package utils

import lotto.Lotto
import model.Prize

class LottoComparator() {
    val result = linkedMapOf(
        Prize.FIFTH_PRIZE to 0,
        Prize.FORTH_PRIZE to 0,
        Prize.THIRD_PRIZE to 0,
        Prize.SECOND_PRIZE to 0,
        Prize.FIRST_PRIZE to 0
    )
    fun compare(purchase: Purchase,winningLotto:Lotto,bonusNumber:Int){
        for(lotto in purchase.item){
            val merged = lotto.getNumber() + winningLotto.getNumber()
            val distinctList = merged.distinct()
            val distinctSize = distinctList.size.toString()
            if (distinctList.size == 7 && lotto.getNumber().contains(bonusNumber) ){
                decidePrize(distinctSize+"1")
                continue
            }
            if (distinctList.size <= 9){
                decidePrize(distinctSize)
            }
        }
    }
    private fun decidePrize(size : String){
        when(size){
            "6" -> result[Prize.FIRST_PRIZE] = result.getOrDefault(Prize.FIRST_PRIZE, 0) + 1
            "71" -> result[Prize.SECOND_PRIZE] = result.getOrDefault(Prize.SECOND_PRIZE, 0) + 1
            "7" -> result[Prize.THIRD_PRIZE] = result.getOrDefault(Prize.THIRD_PRIZE, 0) + 1
            "8" -> result[Prize.FORTH_PRIZE] = result.getOrDefault(Prize.FORTH_PRIZE, 0) + 1
            "9" -> result[Prize.FIFTH_PRIZE] = result.getOrDefault(Prize.FIFTH_PRIZE, 0) + 1
        }
    }
    fun getResult():Map<Prize,Int>{
        return result
    }
}
