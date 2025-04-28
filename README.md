# Lotto Ticket Machine 🎰

A clean, modular Kotlin console application that simulates lottery ticket purchases, draws results, and calculates winnings and profit rates.

## 📄 Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Non-Functional Requirements](#non-functional-requirements)
4. [Assumptions](#assumptions)
5. [Technology Stack](#technology-stack)
6. [Getting Started](#getting-started)
7. [Architecture](#architecture)
8. [Design Patterns & SOLID Principles](#design-patterns--solid-principles)
9. [Usage Example](#usage-example)
10. [Docker](#docker)
11. [Testing](#testing)
12. [Challenges Faced](#challenges-faced)
13. [Project Structure](#project-structure)
14. [Contributing](#contributing)
15. [Contact](#contact)

## Overview
Users enter a purchase amount (₩1,000 per ticket), receive generated tickets, then input winning numbers and a bonus. The program compares each ticket, tallies prize ranks, and displays statistics and a profit rate.

## Features
- **Purchase Processing**: Validates positive multiples of ₩1,000.
- **Ticket Generation**: Issues tickets with 6 unique random numbers (1–45).
- **Result Evaluation**: Compares tickets against winning set plus bonus.
- **Prize Distribution**: Five ranks with fixed KRW prizes.
- **Profit Calculation**: Total return rate, rounded to one decimal.
- **Retry Utility**: Automatic retries for invalid inputs.
- **Observer Pattern**: Flexible console output via listeners.
- **Docker Support**: Container-ready for consistent environments.

## Non-Functional Requirements
- Input validation with meaningful `[ERROR]` messages and re-prompting.
- Use only provided `camp.nextstep.edu.missionutils.Randoms` & `Console`.
- Separate UI (`InputView`/`OutputView`) from core logic.
- Write unit tests for each class (exclude direct System I/O).
- Follow Kotlin conventions; max 2 nesting levels; functions ≤ 10 lines.
- Use TDD with small, feature-focused commits.
- Apply design patterns (Strategy, Observer, DI) where applicable.
- Dockerize the application for deployment consistency.

## Assumptions
- Purchase amount is always a positive integer divisible by ₩1,000.
- Input numbers are comma-separated, without extra whitespace.
- Duplicate numbers in a ticket or winning set are invalid.
- Errors throw `IllegalArgumentException` with prefix `[ERROR]:` and re-prompt.

## Getting Started

### Prerequisites
- Java 17+
- Docker (optional)

### Build & Run Locally
```bash
git clone https://github.com/yourusername/kotlin-lotto-precourse.git
cd kotlin-lotto-precourse
./gradlew clean assemble
./gradlew run
```

## Design Patterns & SOLID Principles
- **Strategy Pattern**: Pluggable number generation via `NumberGenerator`.
- **Observer Pattern**: `LottoObserver` notifies `ConsoleListener` on output.
- **Dependency Injection (DI)**: Validators, generators, observers injected for testability.
- **Single Responsibility Principle (SRP)**: Each class has a single focus.
- **Open/Closed Principle (OCP)**: Extendable without modifying existing code.
- **Liskov Substitution Principle (LSP)**: Implementations can replace abstractions safely.
- **Interface Segregation Principle (ISP)**: Interfaces are minimal and client-specific.
- **Dependency Inversion Principle (DIP)**: High-level modules rely on abstractions (`InputView`, `NumberGenerator`, etc.).

## Usage Example
```
Please enter the purchase amount:
8000

You have purchased 8 tickets:
[3, 5, 11, 16, 32, 38]
[7, 12, 19, 23, 28, 39]
...

Please enter last week's winning numbers:
1,2,3,4,5,6

Please enter the bonus number:
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 ticket
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets

Total return rate is 62.5%.
```

## Docker

```bash
docker build -t lotto-app .
docker run -d lotto-app
```

## Testing

```bash
./gradlew clean test
```

## Challenges Faced
1. Incremental TDD adoption and maintaining small commits.
2. Properly handling CRLF issues in Docker builds on Windows.
3. Balancing validation responsibilities between UI and domain layers.
4. Designing extensible interfaces for observers and generators.
5. Ensuring testability by injecting dependencies and avoiding static calls.

## Project Structure
```
src/
├── main/kotlin/lotto/
│   ├── Application.kt
    ├── Lotto.kt
│   ├── config/Config.kt
│   ├── domain/
│   │   ├── PrizeRank.kt
│   │   └── LottoEngine.kt
│   │   └── ResultCalculator.kt
│   │   ├── TicketMachine.kt
│   ├── engine/
│   │   ├── LottoEngine.kt
│   ├── util/
│   │   ├── NumberGenerator.kt
│   │   ├── DefaultNumberGenerator.kt
│   │   └── Retry.kt
│   ├── validator/
│   │   ├── InputValidator.kt
│   │   ├── IInputValidator.kt
│   ├── observer/
│   │   └── ConsoleListener.kt
│   │   ├── ILottoListener.kt
│   │   ├── ILottoObserver.kt
│   │   ├── LottoObserver.kt
│   └── view/
│       ├── InputView.kt
│       └── OutputView.kt
└── test/kotlin/lotto/
    ├── ApplicationTest.kt
    ├── InputValidatorTest
    ├── LottoTest
    ├── ResultsCalculatorTest
    └── TicketMachineTest
```

## Contributing
1. Fork the repo
2. Create a feature branch
3. Commit changes with clear messages
4. Open a pull request

## Contact
- **Alaa Ismail**
- **Email:** alaaismail286@gmail.com
- **GitHub:** https://github.com/3laaHisham
