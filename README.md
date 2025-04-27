# kotlin-lotto-precourse

A simple lottery ticket simulator built with Kotlin.

## Features

- Read purchase amount (must be divisible by 1,000 KRW) from user input.
- Generate random lottery tickets (each contains 6 unique numbers between 1–45).
- Accept winning numbers and a bonus number from user input.
- Calculate winning ranks and a total return rate.
- Output the results.

## Prize ranks

| Match                  | Prize (KRW)       |
|:------------------------|:------------------|
| 6 numbers               | 2,000,000,000      |
| 5 numbers + bonus ball  | 30,000,000         |
| 5 numbers               | 1,500,000          |
| 4 numbers               | 50,000             |
| 3 numbers               | 5,000              |

## Tech stack

- Kotlin 1.9.24
- JUnit 5 + AssertJ (for unit testing)
- Utils provided: Randoms, Console API

## Requirements

- Must use only Kotlin (no Java code).
- Functions must be under 10 lines.
- Maximum indentation depth: 2 levels.
- Avoid `else`; prefer early returns.
- Use `enum class` for structured constants.
- Separate business logic and UI interaction (InputView, OutputView).
- Unit tests required.

## Example flow

```text
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
...

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
