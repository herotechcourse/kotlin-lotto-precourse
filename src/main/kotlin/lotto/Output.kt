package lotto

object Output {
    fun summary(first: Int, second: Int, third: Int, fourth: Int, fifth: Int,price: Int): String {

        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – $fifth tickets")
        println("4 Matches (50,000 KRW) – $fourth tickets")
        println("5 Matches (1,500,000 KRW) – $third tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – $second tickets")
        println("6 Matches (2,000,000,000 KRW) – $first tickets")

        val sum = (((fifth*5000)+(fourth*50000)+(third*1500000)+(second*30000000)+(first*2000000000)).toDouble()/price)*100

        val gainRating = String.format("%.1f", sum)

        return "Total return rate is $gainRating%."
    }

}