# kotlin-lotto-precourse
## Requirements
1. user enters purchase amount(must be divisible by 1,000)
2. program issues as many lottery tickets as the budget allows(each tickt costs 1,000krw)
3. Each lottery ticket consists of 6 unique random numbers(1-45) -> assign an array or 6 random numbers per ticket
4. user enters the winning number(6 unique numbers 1-45) and a bonus number(bonus number is a single seperate number)
5. check criteria for prize amounts
   - 1st Prize: Match 6 numbers
   - 2nd Prize: Match 5 numbers + bonus
   - 3rd Prize: Match 5 numbers
   - 4th Prize: Match 4 numbers
   - 5th Prize: Match 3 numbers
6. print result : winnings and profit rate

## Notes:
-  must implement the program using the provided Lotto class. 
   - get user input from Application.kt, Lotto.kt issues the lottery tickts with 6 random numbers each
   - get winning number from Application.kt, check criteria at Lotto.kt
   - print result at Application.kt
- Input validation: If the input is invalid, the program throws `IllegalArgumentException` or `IllegalStateException` and re-prompts for input.
- Random number generation uses `Randoms.pickNumberInRange()` from `camp.nextstep.edu.missionutils`.

## How to Run
- gradlew.bat clean test       &emsp;  # Windows 
- ./gradlew clean test            &emsp;  # macOS / Linux