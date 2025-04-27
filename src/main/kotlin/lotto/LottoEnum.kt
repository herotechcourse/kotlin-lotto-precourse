package lotto

enum class LottoEnum (val matchCount:Int,val Amount:Int,val Output:String){

    THREE(3,5000,"3 Matches (5,000 KRW)"),
    FOUR(4,50000,"4 Matches (50,000 KRW)"),
    FIVE(5,1500000,"5 Matches (1,500,000 KRW)"),
    FIVE_BONUS(5,30000000,"5 Matches + Bonus Ball (30,000,000 KRW)"),
    SIX(6,2000000000,"6 Matches (2,000,000,000 KRW)")


}