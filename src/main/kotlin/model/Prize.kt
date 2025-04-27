package model

enum class Prize(val detail : String,val value: Int) {
    FIRST_PRIZE("6 Matches",2000000000),
    SECOND_PRIZE("5 Matches + Bonus Ball",30000000),
    THIRD_PRIZE("5 Matches",1500000),
    FORTH_PRIZE("4 Matches",50000),
    FIFTH_PRIZE("3 Matches",5000);

    fun displayPrize():String{
        return(detail+" (${String.format("%,d",value)} KRW)")
    }

}
