# kotlin-lotto-precourse

## Summary

A lotto simulator implemented in Kotlin as part of the Hero Tech Course pre-course mission 2.

1. Enter the purchase amount. The program issues as many lottery tickets as the budget allows.
2. Enter the winning numbers and a bonus number.
3. The Program compares your tickets to the winning numbers and prints the result, including winning and profit rate.

## Feature List
### ✅ Ticket Purchase
- [x] **Accept purchase amount**
  - [x] Validate that the purchase amount is not blank
  - [x] Validate that the purchase amount is a number
  - [x] Validate that the purchase amount is a positive integer
  - [x] Validate that the purchase amount is divisible by 1,000
- [x] **Issue lottery tickets based on the purchase amount**
  - [x] Validate that the number of issued tickets matches the purchase amount divided by 1,000
  - [x] Validate that each ticket's numbers are in the range from 1 to 45
  - [x] Validate that each ticket's numbers consist of 6 unique numbers

### ✅ Winning numbers
- [x] **Accept winning numbers**
  - [x] Validate that the winning numbers are not blank
  - [x] Validate that the winning numbers are numbers
  - [x] Validate that the winning numbers are positive integers
  - [x] Validate that the winning numbers are in the range from 1 to 45
  - [x] Validate that the winning numbers consist of 6 unique numbers
- [x] **Accept bonus number**
  - [x] Validate that the bonus number is not blank
  - [x] Validate that the bonus number is a number
  - [x] Validate that the bonus number is a positive integer
  - [x] Validate that the bonus number is in the range from 1 to 45
  - [x] Validate that the bonus number is not included in the winning numbers

### ✅ Result Calculation
- [x] **Compare user's tickets to the winning numbers and bonus number**
- [x] **Calculate and show lottery result statistics**
- [x] **Calculate and show profit rate**
  - [x] Validate that the profit rate is rounded to the nearest tenth

### ⚠️ Error Handling
- [x] **Error messages start with `[ERROR]`**
- [x] **Re-prompt input if invalid data is entered**
- [x] **Handle only specific exception types (e.g., `IllegalArgumentException`, `IllegalStateException`), not generic `Exception`**

## Programming Requirements
- [x] The program must be executable with Kotlin 1.9.24.
- [x] You must implement the solution only in Kotlin—Java code is not allowed.
- [x] The entry point of the application must be the main() function in the Application class.
- [x] You may not modify the build.gradle.kts file, and you may not use any external libraries other than those provided.
- [x] Do not use System.exit() or exitProcess() to terminate the program.
- [x] Unless otherwise specified in the requirements, you may not rename or move files, packages, or other project elements.
- [x] Follow the Kotlin Coding Conventions.
- [x] The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
- [x] Keep functions as small and focused as possible—each should do only one thing.
- [x] Use JUnit 5 and AssertJ to test the functionality according to your feature list.
- [x] Keep functions under 10 lines to ensure they perform a single responsibility.
- [x] Avoid using else.
- [x] Use Enum classes where applicable.
- [x] Separate business logic from UI logic.
- [x] Implement unit tests for all logic, except for UI interactions (System.out, System.in).