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

- [ ] Allow the user to input a purchase amount, and keep prompting until the input is valid.
- [ ] Validate that the purchase amount must be an integer, greater than 0, and divisible by 1,000.
- [ ] Generate lotto tickets, each containing 6 unique random numbers between 1 and 45.
- [ ] Display all purchased tickets to user.
- [ ] Allow the user to input the winning numbers, and keep prompting until the input is valid.
- [ ] Validate that the winning numbers must be 6 unique integers between 1 and 45.
- [ ] Allow the user to input the bonus number, and keep prompting until the input is valid.
- [ ] Validate that the bonus number must be a positive integer between 1 and 45, and not duplicate a winning number.
- [ ] Compare each lotto ticket against the winning numbers, and check the bonus number if there are 5 matches to determine the correct rank.
- [ ] Calculate and display the number of tickets for each prize rank, the total prize money, and the return rate.
- [ ] Validate all inputs and handle invalid input by throwing and catching IllegalArgumentException.
- [ ] Follow Kotlin coding conventions (max 2 indentation levels, max 15-line functions)
- [ ] Implement unit tests with JUnit 5 and AssertJ

---

## 🔧 How to Run

```bash
$ ./gradlew run