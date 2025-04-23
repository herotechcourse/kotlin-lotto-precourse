# Kotlin Lottery Ticket Machine

A console based lottery ticket simulator made in Kotlin.
In the app the user has to purchase lottery tickets and earn as much profit as possible by entering the best combination of winning numbers.

## 📌 Table of Contents
- [Features](#features)
- [Validation Rules](#validation-rules)
- [Unit Tests](#unit-tests)

## Features

#### 1. Makes users buy lottery tickets
- Prompts user to purchase lottery tickets for 1,000 KRW each.
- Parses and validates input.
- If input is invalid, throws and IllegalArgumentException and re-prompts the user with the corresponding error message.
- Gives 1 ticket for every 1,000 KRW spent.

#### 2. Creates lottery ticket
- Creates a ticket made of 6 unique numbers in ascending order.
- Creates as many tickets as the amount of money spent.
- Displays lottery ticket(s) to the user.

#### 3. Asks for winning numbers
- Prompts user to write 6 winning unique numbers.
- Parses and validates input.
- Throws IllegalArgumentException and re-prompts the user with the corresponding error message if input is invalid.

#### 4. Asks for bonus number
- Prompts user to write a separate bonus number.
- Parses and validates input.
- If input is invalid, throws and IllegalArgumentException and re-prompts the user with the corresponding error message.

#### 5. Gives winning statistics
- Compares each ticket against winning numbers and bonus.
- Determines the number of winning tickets throughout 5 prize ranks.
- Calculates the profit rate, rounded to the nearest tenth.

## Validation rules
- **Ticket purchase:** must be a number divisible by 1,000.
- **Ticket format:** must have 6 numbers which are comma-separated, unique, ranged 1-45, in ascending order.
- **Winning numbers format:** must have 6 numbers which are comma-separated, unique, ranged 1-45.
- **Bonus number:** must be 1 separate number, ranged 1-45.
- *Error messages*: `[ERROR]` prefix must be shown before the message.

#### Personally added functionalities:
- **Ticket purchase:** limiting spending amount to avoid system overload (for example: user writing excessive numbers such as 1,000,000,000)

## Unit Tests
Written in JUnit5 and AssertJ, covers business logic only:
- **Input validation:** ticket purchase amount, winning numbers, bonus number.
- **Ticket generation:** quantity of given tickets, numbers within tickets.
- **Ticket evaluation:** winning number and bonus number comparison within each purchased ticket.
- **Rank calculation:** assigning matching tickets for each prize rank.
- **Profit calculation:** profit generation from winnings.


>Note: details in this README may change based on the projects' progress