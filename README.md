# kotlin-lotto-precourse

> [!NOTE]
> 
> Learning Objectives
> - Group related functions into classes so that objects collaborate to perform a larger feature.
> - Write unit tests for each class and function to ensure they work as intended.
> - Incorporate as much of the [Feedback on Pre-course Week 1](https://docs.google.com/document/d/1MXczCggC5-mYRzbgcAIDVec4xaTMojIh3vHLGwhTMgQ/edit?usp=sharing) as possible.

## Requirements summary

| Category               | Checkpoint                                                                                        |
|------------------------|---------------------------------------------------------------------------------------------------|
| **Object-Oriented**    | Class level role separation (e.g.,`LottoTicket`, `LottoNumber`, `LottoResult`, `LottoMachine`)    |
| **Feature List**       | Write in `README.md` and use it as a commit standard                                              |
| **Unit Test**          | Write tests for each core class (purchase amount, lotto ticket issuance, winner comparison, etc.) |
| **Output Format**      | **Must** match the output example                                                                 |
| **Exception handling** | Allow only `IllegalArgumentException`, `IllegalStateException` + re-prompt logic is required      |
| **Commit Message**     | Apply [AngularJS commit message rule](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) |
| **Minimum E2E Test**   | `./gradlew clean test` and then check `BUILD SUCCESSFUL`                                          |


## Personal objectives

- Write detailed feature list as a reference for test cases
- Adopt TDD (Test Driven Development) as a development method
- Adopt Domain concept, rather than MVC pattern
  - Because the lottery system is a real world concept which should be defined and expressed in detail


## Key design goals

- Clearly separate domain logic and UI (Input/Output)
- Each class is designed to have one responsibility (SRP)
- Separate into testable structures


## Terms and Definitions

- A **lotto** or a **ticket** is a list of 6 numbers those are in range of 1 to 45 without duplicate.
- A **bundle** is a list of lotto(s) or lotto ticket(s) 


## Feature List

### 1. Input Handling
- [x] Purchase Amount Input
  - [x] Prompt user for the purchase amount
  - [x] Verify it is a positive number divisible by 1000
  - [x] Throw exception for invalid input (negative, zero, non-numeric, less than 1000)
- [x] Winning Numbers Input
  - [x] Prompt user for 6 comma-separated numbers
  - [x] Verify all numbers are in range 1-45 and not duplicated
  - [x] Throw exception for invalid format (empty, blank, more, less)
  - [x] Throw exception for invalid input (negative, zero, non-numeric)
- [x] Bonus Number Input
  - [x] Prompt user for 1 number
  - [x] Verify the number is in range 1-45 and not duplicated from the winning numbers
  - [x] Throw exception for invalid input (negative, zero, non-numeric)

### 2. Lotto Issuance
- [x] Calculate number of tickets based on purchase amount
- [x] Generate lotto bundle:
  - [x] Each ticket contains 6 unique random numbers between 1-45
  - [x] Numbers are sorted in ascending order
- [x] Display all generated tickets

### 3. Winning Calculation
- [x] Compare each ticket against the winning number
  - [x] Count matching numbers
  - [x] Check if the bonus number matches
- [x] Determine rank based on match:
  - [x] 6 matches: 1st (2,000,000,000 won)
  - [x] 5 + bonus: 2nd (30,000,000 won)
  - [x] 5 matches: 3rd (1,500,000 won) 
  - [x] 4 matches: 4th (50,000 won)
  - [x] 3 matches: 5th (5,000 won)
- [x] Count number of tickets in each rank

### 4. Return Rate
- [x] Calculate total winnings
- [x] Calculate and display the rate of return (to one decimal place)

### 5. Output Handling
- [x] Print: 
  - [x] Number of purchased tickets and their numbers
  - [x] Winning statistics (follow example format in requirements)
  - [x] Return rate (e.g. `Total return rate is 62.5%.`)

### 6. Exception Handling
- [x] Throw `IllegalArgumentException` or `IllegalStateException` for invalid inputs
- [x] All error messages start with `[ERROR]`
- [x] Re-prompt when the user on invalid input

### 7. Structure and Testing
- [x] `Lotto` class: 
  - [x] Contains **ONLY** `numbers` field
  - [x] **MUST** include validation with test code
- [x] Separate `InputView` and `OutputView` for I/O handling
- [x] Write unit tests for:
  - [x] Core logic (ticket generation, match checking, ranking, etc.)
  - [x] Exception cases and input validation
