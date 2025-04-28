package lotto

object OutputView {

    // 로또 티켓을 출력하는 함수
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} ticket${if (tickets.size > 1) "s" else ""}.")
        tickets.forEach {
            println("[${it.getNumbers().joinToString(", ")}]")  // 이미 정렬된 번호이므로 .sorted() 제거
        }
    }

    // 로또 결과를 출력하는 함수

fun printStats(result: LottoResult, rate: Double) {
    println("Winning Statistics")
    println("---")
    Rank.values().reversed().forEach { rank ->  // 내림차순으로 출력
        val count = result.count(rank)
        if (rank != Rank.NONE) {
            val ticketWord = "tickets"  // 항상 복수형 'tickets'로 변경
            println("${rank.description()} – $count $ticketWord")
        }
    }
    println("Total return rate is ${"%.1f".format(rate)}%.")  // 1자리 소수점으로 반환률 출력
}
}
