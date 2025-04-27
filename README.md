<div align = "justify">

# kotlin-lotto-precourse

This is a simple command-line Lotto simulation developed in Kotlin for the Hero Tech Course: Berlin Edition pre-course mission 2. Users purchase lottery tickets, input winning numbers and a bonus number, and the programme calculates match results and the total return rate.

<br>

---

## Features

- [x] Input purchase amount
- [x] Generate correct number of tickets (₩1,000 per ticket)
- [x] Validate each ticket has 6 unique numbers in range 1–45
- [x] Input 6 winning numbers + 1 bonus number
- [x] Compare user tickets to winning numbers
- [x] Calculate prize counts and profit rate
- [x] Handle errors with proper message format `[ERROR]`
- [x] Use only IllegalArgumentException or IllegalStateException for validation
- [x] Ensure output format matches exactly
- [x] All test cases should be passed using `./gradlew clean test`

<br>

---

## How to run tests

For macOS/Linux:
```bash
./gradlew clean test
```

<br>

For Windows:
```bash
gradlew.bat clean test # or
.\gradlew.bat clean test
```

<br>

---

## Example Output

- Number of tickets issued and their numbers (sorted in ascending order):
```
You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

- Lotto result statistics:
```
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
```

- Profit rate rounded to the nearest tenth (e.g., 100.0%, 51.5%, 1,000,000.0%):
```
Total return rate is 62.5%.
```

- Error messages must start with `[ERROR]`:
```
[ERROR] Lotto numbers must be between 1 and 45.
```

<br>

---

## Example Execution

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

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```

<br>

---

## Project Structure

```
└── src
    ├── main
    │   └── kotlin
    │       └── lotto
    │           ├── Application.kt
    │           ├── Lotto.kt
    │           ├── LottoMachine.kt
    │           ├── LottoResult.kt
    │           ├── Rank.kt
    │           └── view
    │               ├── InputView.kt
    │               └── OutputView.kt
    └── test
        └── kotlin
            └── lotto
                ├── ApplicationTest.kt
                └── LottoTest.kt
```

<br>

</div>
