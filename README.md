# Lotto Ticket Machine

A console application in Kotlin that simulates a lottery ticket purchase and result checking system.

## Functional Requirements
- Prompt user for purchase amount (must be a multiple of 1,000 KRW).
- Issue as many tickets as the amount allows (1 ticket = 1,000 KRW).
- Each ticket contains 6 unique random numbers in the range 1–45.
- Prompt user for winning numbers (6 unique, 1–45) and a bonus number (1–45, not in winning set).
- Compare each ticket against winning numbers:
    - 6 matches → 1st prize
    - 5 matches + bonus → 2nd prize
    - 5 matches       → 3rd prize
    - 4 matches       → 4th prize
    - 3 matches       → 5th prize
- Display:
    - Number of tickets purchased and their numbers (sorted ascending).
    - Count per prize rank.
    - Total return rate (profit/expense) rounded to one decimal place.

## Non-Functional Requirements
- Input validation with meaningful `[ERROR]` messages and re-prompting.
- Use only provided `camp.nextstep.edu.missionutils.Randoms` & `Console`.
- Separate UI (`InputView`/`OutputView`) from core logic.
- Write unit tests for each class (exclude direct System I/O).
- Follow Kotlin conventions; max 2 nesting levels; functions ≤ 10 lines.
- Use TDD with small, feature-focused commits.
- Use design patterns, Strategy and Observer, where applicable.
- Dockerize the application.

## Assumptions
- Purchase amount always a positive integer.
- Input numbers are comma-separated, no extra whitespace.
- Duplicate numbers in a ticket or winning set are invalid.
- Errors throw `IllegalArgumentException` with prefix `[ERROR]:` and re-prompt.

---
