# Lotto Ticket Machine

A simple lottery ticket machine built in Kotlin.

## Description

This program simulates a lottery ticket machine's process:
- InputView accepts the input of purchase amount (in KRW).
- Lotto Generates tickets( 1000 KRW per ticket ) which contains 6 unique random numbers from 1 to 45.
- InputView accepts the input for winning numbers + bonus number.
- Lotto compares tickets to winning numbers.
- OutputView displays lottery result statistics and total return rate.

---

## Features To Implement

- [ ] InputView: input purchase amount (must be divisible by 1,000) until input amount is valid
- [ ] InputView: generate lotto tickets (each with 6 unique random numbers between 1 and 45)
- [ ] OutputView: display all purchased tickets
- [ ] InputView: input winning numbers (6 unique numbers between 1 and 45) until input is valid
- [ ] InputView: input bonus number (must be between 1 and 45, and not a duplicate from winning number) until input is valid
- [ ] Lotto: compare all tickets to winning numbers and determine ranks
- [ ] OutputView: calculate total prize money and profit rate , display prize rank details and profit statistics
- [ ] InputValidate: validate all inputs (throw and handle `IllegalArgumentException` on invalid input)
- [ ] Follow Kotlin coding conventions (max 2 indentation levels, max 15-line functions)
- [ ] Implement unit tests with JUnit 5 and AssertJ

---

## 🔧 How to Run

```bash
$ ./gradlew run