# kotlin-lotto-precourse

---

## About the Project
This application is a console-based Lotto ticket machine.  
It generates random Lotto tickets based on user input, accepts winning numbers and a bonus number, evaluates ticket results, and calculates the total profit rate.

---

## Features

### Input Handling
- Prompt user to enter purchase amount (must be divisible by 1,000)
- Accept 6 unique winning numbers (each between 1–45)
- Accept 1 bonus number (must not duplicate any winning number)
- Show `[ERROR]` messages and re-prompt input automatically

### Lotto Ticket Generation
- Issue one ticket per 1,000 KRW
- Each ticket contains 6 unique random numbers between 1 and 45
- Numbers are sorted in ascending order
- Random numbers generated using `Randoms.pickUniqueNumbersInRange`

### Result Evaluation
- Match ticket numbers to winning numbers and bonus number
- Determine prize ranks:
  - 1st: 6 matches → 2,000,000,000 KRW
  - 2nd: 5 matches + bonus → 30,000,000 KRW
  - 3rd: 5 matches → 1,500,000 KRW
  - 4th: 4 matches → 50,000 KRW
  - 5th: 3 matches → 5,000 KRW

### Statistics & Profit Rate Calculation
- Aggregate ticket results
- Calculate and display total return rate formatted to one decimal place

### Output Display
- Print number of purchased tickets
- Display all generated ticket numbers
- Show winning statistics grouped by prize tier
- Print total profit rate

---

## Testing

- Achieved 100% unit test coverage for business logic
- Tests cover:
  - Ticket generation and validation
  - Winning numbers validation and ticket matching
  - Rank evaluation logic
  - Statistics and profit calculation
  - Retry behavior
- Input/Output operations excluded from unit testing (as required)
- JUnit 5 and AssertJ used for testing

---
## Sources

- [Hero Tech Pre-course Mission Guidelines](https://docs.google.com/document/d/1mpJtYaGOaLtk_K3yk3qqTowOWWqz94_fgS3UXFn-qZA/edit?tab=t.0#heading=h.j54y4c3df9nv)
- [Kotlin Official Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ Assertions Guide](https://assertj.github.io/doc/)
- [AngularJS Git Commit Message Conventions](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#commit)