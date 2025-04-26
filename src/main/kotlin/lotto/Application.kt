package lotto



fun main() {

    val price = readLine()!!.toInt()
    val numbers = readln().split(",").map {it.toInt() }

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


    val juan=Lotto(listOf(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5]))
    val CreatedRandomLottos=juan.CreateLottoList(lottocount)
    val sortedNumbers=juan.getNumbers()

    for(i in CreatedRandomLottos){

    }



    print(sortedNumbers)

    }

