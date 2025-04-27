package utils

import lotto.Lotto

class Purchase (val item : List<Lotto>){
    companion object{
        fun make(amount : Int):Purchase{
            val list = ArrayList<Lotto>()
            var count = 0
            while (count<amount){
                var lotto = Lotto.generate()
                list.add(lotto)
                count++
            }
            return Purchase(list)
        }
    }
    fun displayPurchase(){
        for (lotto in item){
            OutputView.print("[${lotto.displayLotto()}]")
        }
    }
}