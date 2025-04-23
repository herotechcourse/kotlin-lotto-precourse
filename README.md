# kotlin-lotto-precourse

### Feature List:

* User Interface [ ]
  * Prompt the user [ ]
  * Take user input [ ]
  * Parse user input [ ]
  * Produce messages to the user [ ]
  * Error management (Throw Exception + re-prompt same step input) [ ]
* Lotto [ ]
  * Ticket purchase [ ]
    * Amount of tickets [ ]
    * Ticket generation [ ]
  * Numbers selection [ ]
  * Lotto results [ ]
    * Lotto outcome [ ]
    * Total return rate [ ]
* Unit Tests [ ]

---

### Functional Requirements
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

#### Example Execution:
```bash
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```

#### Error messages must start with [ERROR]:
```bash
[ERROR] Lotto numbers must be between 1 and 45.
```

### Programming Requirements
* The program must be executable with Kotlin 1.9.24.
* You must implement the solution only in Kotlin—Java code is not allowed.
* The entry point of the application must be the main() function in the Application class.
* You may not modify the build.gradle.kts file, and you may not use any external libraries other than those provided.
* Do not use System.exit() or exitProcess() to terminate the program.
* Unless otherwise specified in the requirements, you may not rename or move files, packages, or other project elements.
* Follow the Kotlin Coding Conventions.
* The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
  * For example, an if statement inside a while loop is acceptable, but nesting beyond that is not.
  * Tip: To reduce indentation depth, extract logic into functions.
* Keep functions as small and focused as possible—each should do only one thing.
* Use JUnit 5 and AssertJ to test the functionality according to your feature list.
* Keep functions under 10 lines to ensure they perform a single responsibility.
* Avoid using else.
  * In many cases, early return can eliminate the need for else.
* Use Enum classes where applicable.
* Separate business logic from UI logic.
  * Use dedicated classes such as InputView and OutputView to clearly isolate UI-related code from core functionality.
* Implement unit tests for all logic, except for UI interactions (System.out, System.in).
  * If you're not familiar with writing unit tests, refer to LottoTest as a learning reference before writing your own.

### Library
You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package.
* To generate random values, use Randoms.pickUniqueNumbersInRange() from camp.nextstep.edu.missionutils.Randoms.
* To receive user input, use Console.readLine() from camp.nextstep.edu.missionutils.Console.

### Lotto Class
* You must implement your program using the provided Lotto class.
* You must not add any fields (instance variables) to the Lotto class other than numbers.
* The visibility modifier private on numbers must not be changed.
* You must not change the package of the Lotto class.

```kotlin
package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions
}
```