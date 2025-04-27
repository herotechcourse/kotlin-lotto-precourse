package lotto

import lotto.Lotto.Companion.CreateLottoList


fun main() {
    print("Please enter the purchase amount.")
    val price = readLine()!!.toInt()


//    for (i in numbers) {
//        if (numbers[i] > 45)
//            IllegalArgumentException();
//        for(j in numbers){
//            if(numbers[i]==numbers[j]){
//                IllegalArgumentException();//이러면 안됨.
//            }
//        }
//    }


    if(price%1000!=0){
        IllegalArgumentException();
    }
     val lottocount=price/1000
    print("Please enter last week's winning numbers.")
    val numbers = readln().split(",").map {it.toInt() }

    print("Please enter the bonus number.")
    val BonusNumber=readLine()!!.toInt()
    println("You have purchased "+lottocount.toString()+" tickets..")



    val juan=Lotto(listOf(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]))
    val CreatedRandomLottos=CreateLottoList(lottocount)//static으로 바꾼 이유..
    val sortedNumbers=juan.getNumbers()
    var first=0
    var second=0
    var third=0
    var fourth=0
    var fifth=0


    for (lotto in CreatedRandomLottos) {
        println(lotto.getNumbers())
    }

    for(i in 0..lottocount-1){
        val correctLotto=juan.CorrectNumbers(CreatedRandomLottos[i].getNumbers(),sortedNumbers,BonusNumber)
        when(correctLotto){
            3->fifth+=1
            4->fourth+=1
            5->third+=1
            6->second+=1
            7->first+=1
        }
    }

    println("Winning Statistics")
    println("---")
    println("3 Matches (5,000 KRW) - "+fifth.toString()+"tickets")
    println("4 Matches (50,000 KRW) - "+fourth.toString()+"tickets")
    println("5 Matches (1,500,000 KRW) - "+third.toString()+"tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) "+second.toString()+"tickets")
    println("6 Matches (2,000,000,000 KRW) - "+first.toString()+"tickets")

val sum = (((fifth*5000)+(fourth*50000)+(third*1500000)+(second*30000000)+(first*2000000000)).toDouble()/price)*100
    println("Total return rate is "+sum.toString()+"%")

    
    }

