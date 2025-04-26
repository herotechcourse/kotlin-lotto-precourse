# kotlin-lotto-precourse

## Project Overview

This is a **Kotlin 1.9.24** project for building a simple lottery ticket machine.  
The application allows users to purchase lotto tickets, enter winning numbers and a bonus number, and check their results.

---

## Features

- Accepts user input for purchase amount and issue lotto tickets.
- Each ticket costs **1,000 KRW** and contains **6 unique random numbers** between **1** and **45**.
- Display the number of tickets purchased and their numbers (sorted in ascending order).
- Accepts **winning numbers** (6 numbers) and a **bonus number** (1 number) from the user.
- Matches purchased tickets against the winning numbers and determines the winning rank:
    - 1st Prize: 6 matches — **2,000,000,000 KRW**
    - 2nd Prize: 5 matches + bonus — **30,000,000 KRW**
    - 3rd Prize: 5 matches — **1,500,000 KRW**
    - 4th Prize: 4 matches — **50,000 KRW**
    - 5th Prize: 3 matches — **5,000 KRW**
- Displays lotto result statistics (number of winning tickets per rank).
- Calculates and displays the **profit rate** (rounded to the nearest tenth).
- Handles invalid input (throw and re-prompt on IllegalArgumentException).
- Error messages start with `[ERROR]`.

---

## Programming Requirements

- Programming Language: **Kotlin 1.9.24** only.
- Entry Point: `main()` function in `Application.kt`.
- Libraries: Only **Randoms** and **Console** from `camp.nextstep.edu.missionutils`.
- No external libraries or modifications to `build.gradle.kts`.
- No use of `exitProcess()` or `System.exit()`.
- Follow **Kotlin Coding Conventions**:
    - Max 2 levels of indentation.
    - Functions under 10 lines.
    - Avoid using `else` by using early returns.
    - Use `enum class` where applicable.
- **Separate UI logic** and **business logic**:
    - InputView handles inputs.
    - OutputView handles outputs.
- Unit Testing:
    - Use **JUnit 5** and **AssertJ**.
    - Test only business logic (no testing of UI).
- Use provided `Lotto.kt` class and only add methods without changing visibility.

---

## Testing

- All business logic is unit tested with **JUnit 5** and **AssertJ**.
- Exception handling tests ensure invalid inputs are properly managed.

---

## Example Usage

Please enter the purchase amount.
8000

You have purchased 8 tickets. <br>
[8, 21, 23, 41, 42, 43] <br>
[3, 5, 11, 16, 32, 38] <br>
[7, 11, 16, 35, 36, 44] <br>
[1, 8, 11, 31, 41, 42] <br>
[13, 14, 16, 38, 42, 45] <br>
[7, 11, 30, 40, 42, 43] <br>
[2, 13, 22, 32, 38, 45] <br>
[1, 3, 5, 14, 22, 45] 

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics <br>
<span>---</span> <br>
3 Matches (5,000 KRW) – 1 tickets <br>
4 Matches (50,000 KRW) – 0 tickets <br>
5 Matches (1,500,000 KRW) – 0 tickets <br>
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets <br>
6 Matches (2,000,000,000 KRW) – 0 tickets <br>
Total return rate is 62.5%. <br>

---

## How to Run

1. Clone the repository.
2. Open with **IntelliJ IDEA**.
3. Run the `Application.kt` file to start the program.
4. Follow the prompts to play!



