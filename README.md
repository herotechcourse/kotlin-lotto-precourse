# kotlin-lotto-precourse

This is a simple command-line Lotto game built in Kotlin as part of a pre-course mission.  
The project aims to allow users to purchase lottery tickets, generate winning numbers, and determine the results based on matching numbers.

---

## Planned Features

- [x] Ask the user for the amount they want to spend
- [x] Automatically issue lottery tickets based on the amount (each ticket costs 1000 won)
- [x] Generate random lottery numbers for each ticket (numbers from 1 to 45, no duplicates, sorted)
- [x] Allow the user to input the winning numbers and bonus number
- [x] Compare purchased tickets with the winning numbers
- [x] Determine the prize for each ticket (1st ~ 5th prizes based on matches)
- [x] Display the overall winning statistics
- [x] Calculate and display the return on investment (ROI)

---

## Commit Strategy

All commits follow the [Conventional Commit](https://www.conventionalcommits.org/en/v1.0.0/) format:

Examples:
- `feat: add LottoTicket class with random number generation`
- `fix: correct duplicate number validation in user input`
- `docs: update README with planned feature list`

---

## How to Run

To run the program from the command line, use:

```declarative
./gradlew run
```
You will be prompted to enter the amount of money and winning numbers.

Example:

Enter the purchase amount:
```declarative
3000
```
Enter the winning numbers (comma-separated):
```
8,21,23,41,42,43
```
Enter the bonus number:
```declarative
10
```
Make sure Kotlin and Gradle are properly set up in your environment.

---

## How to Test

To run the tests, open a terminal in the project root and run:
```declarative
./gradlew clean test
```
If all tests pass, you should see:
```declarative
BUILD SUCCESSFUL
```
---

## Notes

- The project is written in Kotlin 1.9.24 and follows Kotlin coding conventions.
- All commits follow the Conventional Commit format.
- The project uses only the provided `camp.nextstep.edu.missionutils` library for random number generation and user input.
- Tests are written using JUnit 5 and AssertJ.
- No external libraries beyond those provided were used.
- This README file will be updated as the project evolves.
