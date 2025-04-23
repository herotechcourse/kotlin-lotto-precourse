# kotlin-lotto-precourse
## Functional Requirements
Implement a simple lottery ticket machine with the following rules:

* The user enters the purchase amount, and the program issues as many lottery tickets as the budget allows.
    * Each ticket costs 1,000 KRW, so the amount must be divisible by 1,000.
* Each lottery ticket consists of 6 unique random numbers.
  * Numbers must be in the range from 1 to 45.
* The user then enters the winning numbers and a bonus number.
  * The winning numbers consist of 6 unique numbers.
  * The bonus number is a single, separate number.
* There are five prize ranks. The criteria and prize amounts are as follows:
  * 1st Prize: Match 6 numbers / 2,000,000,000 KRW
  * 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
  * 3rd Prize: Match 5 numbers / 1,500,000 KRW
  * 4th Prize: Match 4 numbers / 50,000 KRW
  * 5th Prize: Match 3 numbers / 5,000 KRW
* The program compares the user's tickets to the winning numbers and prints the result, including winnings and profit rate.
* If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.
  * Handle only specific exception types such as IllegalArgumentException or IllegalStateException, not generic Exception.