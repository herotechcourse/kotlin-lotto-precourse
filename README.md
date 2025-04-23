# kotlin-lotto-precourse
##  Features

###  Input Handling
-  Prompt user to enter purchase amount (must be divisible by 1,000)
- Accept 6 unique winning numbers (1–45)
- Accept 1 bonus number (must not duplicate any winning number)
- Show `[ERROR]` messages and re-prompt on invalid input

###  Lotto Ticket Generation
- One ticket per 1,000 KRW
- Each ticket has 6 unique random numbers (1–45)
- Ticket numbers sorted in ascending order
- Uses `Randoms.pickUniqueNumbersInRange`

###  Result Evaluation
- Compare tickets to winning numbers and bonus number
- Determine rank:
    - 1st: 6 matches → 2,000,000,000 KRW
    - 2nd: 5 + bonus → 30,000,000 KRW
    - 3rd: 5 matches → 1,500,000 KRW
    - 4th: 4 matches → 50,000 KRW
    - 5th: 3 matches → 5,000 KRW

### Statistics & Profit rate Calculation
- Ticket result aggregation and rank count handled by `LottoStatistics.kt`
- Profit rate calculation (return rate) is **cleanly separated** from output logic


### Output Display
- Print the number of tickets purchased
- Display all generated ticket numbers
- Show match statistics by prize tier
- Print total profit rate (formatted as a percentage)
- All output handled by `OutputView.kt`

---

## Testing

- Unit tests for all core logic using **JUnit 5** and **AssertJ**
- Tests cover:
    - Ticket and input validation
    - Random ticket generation
    - Ranking logic
    - Statistics and profit calculation
- Input/output is excluded from testing

---

## How to Run

### Run Tests
```bash
./gradlew clean test     # macOS/Linux
gradlew.bat clean test   # Windows