# kotlin-lotto-precourse

This project implement an amazing lottery ticket machine that allows users to purchase tickets, enter winning numbers, and calculate their winnings based on matching numbers.
This Lotto project is part of the Hero Tech Course curriculum.

<picture>
 <img alt="racingCar" src="https://github.com/user-attachments/assets/45b956eb-0590-4ecd-a051-b31fb6c8e882">
</picture>

## Features

### Core Functionality

- [x] Purchase lottery tickets based on input amount (1000 KRW per ticket)
- [x] Generate random lottery tickets (6 unique numbers from 1-45)
- [x] Get Input Winning numbers and bonus number
- [x] Compare user tickets against winning numbers
- [x] Calculate and display prize statistic
- [x] Calculate and display return rate

### Input Validations

- [x] Validate purchase amount is divisible by 1000
- [x] Validate lottery numbers are between 1 and 45
- [x] Ensure each ticket numbers are unique
- [x] Ensure that the winning numbers are unique
- [x] Validate bonus number is valid and not duplicated in winning numbers

### Error Handling

- [x] Display appropriate error messages for invalid inputs
- [x] Re-prompt user after invalid input.
- [x] Handle only `IllegalArgumenthexception` and `IllegalStateException`

### User Interface

- [x] Clear prompts for user input
- [x] Formatted display of purchased tickets
- [x] Organized presentation of winning statistics
- [x] Display return rate rounded to nearest tenth

## Architecture

For this project I decided to maintain an Hybrid MVC architecture with domain-driven design (DDD) elements, which is a pattern that balances the separation of concerns across the view and business logic.
To align with the project requirements and prototypes, I've made some modifications to simplify the structure and improve clarity, maintaining all the properties of DDD.

### Domain Layer

- Encapsulates the core business logic and entities.
- Also includes domain-specific utilities and constants.

### Services Layer

- Handles application-specific operations, assuming a role somewhat similar to traditional MVC controllers.
- However, in this project orchestration is performed by Application.kt, which invokes services to interact with the domain layer.
- This approach improving modularity and enabling the possibility to reuse services with other type of controllers, promoting extensibility.

### View Layer

- Manages input and output interactions
- Contains `InputView` for get the user input.
- Contains `OutputView` for displaying results and messages

## Programming Requirements

### Technology Stack

- language: Kotlin 1.9.24
- Testing Framework: JUnit 5, AssertJ
- Utilities: camp.nextstep.edu.missionutils (Randoms, Console)
- Architecture: Domain-View-Controller pattern

### Development Approach

- Separation of UI and business logic
- Single responsibility functions (under 10 lines)
- Maximum indentation depth of 2
- Test-Driven development for core functionality
- Avoiding else statements through early returns
- Using enums for categorization
- Following Kotlin coding conventions
- Following feedback on week one

## Functional Requirements

- The user enters the purchase amount, each ticket cost 1000 KRW
- Each lottery ticket consists of 6 unique random numbers in the range of 1 to 45.
- The user enters the winning numbers and a bonus number. This numbers should be also unique.
- There are five prize ranks:

  | Prize Tier | Winning Criteria               | Prize Amount (KRW) |
  | ---------- | ------------------------------ | -----------------: |
  | 1st Prize  | Match 6 numbers                |      2,000,000,000 |
  | 2nd Prize  | Match 5 numbers + bonus number |         30,000,000 |
  | 3rd Prize  | Match 5 numbers                |          1,500,000 |
  | 4th Prize  | Match 4 numbers                |             50,000 |
  | 5th Prize  | Match 3 numbers                |              5,000 |

- The Program compare the user's tickets to the winning numbers and prints the result, including winnings and profit rate.
- If invalid input, the program must throw `IllegalArgumentException` and re-prompt input from that step.
  - Only handle `IllegalArgumentExcepiton` and `IllegalStateException`.

### Example Execution

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
3 Matches (5,000 KRW) - 1 ticket
4 Matches (50,000 KRW) - 0 tickets
5 Matches (1,500,000 KRW) - 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) - 0 tickets
6 Matches (2,000,000,000 KRW) - 0 tickets
Total return rate is 62.5%.
```
