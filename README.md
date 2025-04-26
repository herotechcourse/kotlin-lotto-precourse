# kotlin-lotto-precourse

## 📚 Overview
A simple lottery simulation built with **Kotlin 1.9.24**.  
The program allows users to purchase tickets, input winning numbers, and receive result statistics including profit rate.

---

## ⚙ Technologies Used
- **Kotlin 1.9.24** — Main programming language.
- **Gradle** — Build tool (using `build.gradle.kts`).
- **JUnit 5** — Unit testing framework.
- **AssertJ** — Fluent assertions for tests.
- **camp.nextstep.edu.missionutils**
    - `Randoms.pickNumberInRange()` — Random number generator.
    - `Console.readLine()` — User input reader.
---

## 🔍 Features

- Buy multiple lotto tickets based on your input amount
- Randomly generate lotto numbers for each ticket
- Validate user inputs (amount, winning numbers, bonus number)
- Match winning numbers against purchased tickets
- Calculate and display total winnings and return on investment

## 📈 Rules of the Lotto Game

- Buy lotto tickets at 1,000 KRW per ticket
- Each ticket has 6 unique numbers between 1 and 45
- After purchase, input the week's winning numbers and a bonus number
- Your earnings are calculated based on how many numbers match

| Rank | Match Condition                      | Prize Money (KRW) |
|:----:|:-------------------------------------:|:-----------------:|
|  1   | 6 numbers match                       | 2,000,000,000     |
|  2   | 5 numbers match + bonus number        | 30,000,000        |
|  3   | 5 numbers match                       | 1,500,000         |
|  4   | 4 numbers match                       | 50,000            |
|  5   | 3 numbers match                       | 5,000             |

---

## 🖥️ Input/Output Example

**Input:**

```
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
```
**Output:**

```
Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```

#### Author: Dinely Shanuka