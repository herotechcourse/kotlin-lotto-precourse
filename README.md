# kotlin-lotto-precourse
## Functional Requirements
- [x] The user enters the purchase amount, and the program issues as many lottery tickets as the budget allows.
  - [x] Each ticket costs 1,000 KRW, so the amount must be divisible by 1,000.
- [x] Each lottery ticket consists of 6 unique random numbers.
  - [x] Numbers must be in the range from 1 to 45.
- [x] The user then enters the winning numbers and a bonus number.
  - [x] The winning numbers consist of 6 unique numbers.
  - [x] The bonus number is a single, separate number.
- [x] There are five prize ranks. The criteria and prize amounts are as follows:
    - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
    - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
    - 3rd Prize: Match 5 numbers / 1,500,000 KRW
    - 4th Prize: Match 4 numbers / 50,000 KRW
    - 5th Prize: Match 3 numbers / 5,000 KRW
- [x] The program compares the user's tickets to the winning numbers and prints the result, including winnings and profit rate.
- [x] If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.
  - [x] Handle only specific exception types such as IllegalArgumentException or IllegalStateException, not generic Exception.

## Function List
- [x] Lotto must contain exactly 6 numbers.
- [x] Lotto must contain unique numbers.
- [x] All numbers must be in the range of 1 to 45.
- [x] Lotto generator has to make a random lottos according to purchase amount.
- [x] Price calculator can calculate the return rate.
- [x] Winning checker can count the winning lottos.

## Programming Requirements
- [x] The program must be executable with Kotlin 1.9.24.
- [x] You must implement the solution only in Kotlin—Java code is not allowed.
- [x] The entry point of the application must be the main() function in the Application class.
- [x] You may not modify the build.gradle.kts file, and you may not use any external libraries other than those provided.
- [x] Do not use System.exit() or exitProcess() to terminate the program.
- [x] Unless otherwise specified in the requirements, you may not rename or move files, packages, or other project elements.
- [x] Follow the Kotlin Coding Conventions.
- [x] The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
- [x] Keep functions as small and focused as possible—each should do only one thing.
- [x] Use JUnit 5 and AssertJ to test the functionality according to your feature list.
- [x] Keep functions under 10 lines to ensure they perform a single responsibility.
- [x] Avoid using `else`.
- [x] Use Enum classes where applicable.
- [x] Separate business logic from UI logic.
- [x] Implement unit tests for all logic, except for UI interactions (System.out, System.in).
- [x] You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package.
- [x] You must implement your program using the provided Lotto class.
- [x] You must not add any fields (instance variables) to the Lotto class other than numbers.
- [x] The visibility modifier private on numbers must not be changed.
- [x] You must not change the package of the Lotto class.
