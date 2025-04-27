package lotto

enum class Prize(val prizeMoney:Int, val matchType:String, val result:String, var cnt:Int) {
    FIFTH(5000,"3","3 Matches (5,000 KRW)",0),
    FOURTH(50000,"4","4 Matches (50,000 KRW)",0),
    THIRD(1500000,"5","5 Matches (1,500,000 KRW)",0),
    SECOND(30000000,"bonus","5 Matches + Bonus Ball (30,000,000 KRW)",0),
    FIRST(2000000000,"6","6 Matches (2,000,000,000 KRW)",0);


    companion object {
        fun getMoney(typeofMatch: String):Int {
            val money=0
            Prize.entries.forEach{
                if(it.matchType==typeofMatch) return it.prizeMoney
            }
            return money
        }

        fun getResultMatch(){
            Prize.entries.forEach{
                println(it.result+" - "+it.cnt+" tickets")
            }
        }
    }
}





