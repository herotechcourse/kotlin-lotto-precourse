# kotlin-lotto-precourse

# Feature Specification

## Game Rules

- [x] The ticket price is fixed at 1,000 KRW.
    - [x] The purchase amount must be divisible by 1,000.
- [x] Generate a single lottery ticket with 6 random numbers.
    - [x] The numbers must be unique.
    - [x] The numbers must be in the range 1 to 45 (inclusive).
- [x] Generate multiple lottery tickets based on the user's purchase amount.
    - [ ] There are no two different tickets with the same six numbers.
- [x] Accept 6 winning numbers from the user.
    - [x] The numbers must be unique.
    - [x] The numbers must be in the range 1 to 45 (inclusive).
- [x] Accept 1 bonus number from the user.
    - [x] The bonus number must be different from the winning numbers.
- [x] Compare each ticket with the winning numbers and bonus number.
- [x] Determine the prize rank based on the number of matches and the bonus number.
    ```
    The criteria and prize amounts are as follows:
    1st Prize: Match 6 numbers / 2,000,000,000 KRW
    2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
    3rd Prize: Match 5 numbers / 1,500,000 KRW
    4th Prize: Match 4 numbers / 50,000 KRW
    5th Prize: Match 3 numbers / 5,000 KRW
    ```
- [ ] Calculate total winnings based on all purchased tickets.
- [x] Calculate the profit rate from the winnings and the total purchase amount.

## Input Rules

- [x] Prompt the user for the purchase amount.
    - [x] Validate that the input is numeric.
    - [x] Validate that the input is positive.
- [x] Prompt the user to enter 6 winning numbers.
    - [x] Validate that the input is numeric.
    - [x] Enter the Comma-Separated input
    - [x] Can input blank between Comma and data.
- [ ] Prompt the user to enter a bonus number.
    - [ ] Validate that the input is numeric.
- [ ] If any input is invalid:
    - [ ] Display an appropriate error message that starts with `ERROR`
    - [ ] Re-prompt from the same step.

---

## Output Rules

- [ ] Print the number of tickets purchased.
- [ ] Print each ticket's numbers.
- [ ] After the game ends:
    - [ ] Display the count of matches for each prize rank.
    - [ ] Display the total amount won.
    - [ ] Display the profit rate.
        - [ ] Profit rate rounded to the nearest tenth (e.g., 100.0%, 51.5%, 1,000,000.0%)

# Programming Conventions

- Do not catch generic exceptions (e.g., `Exception`).
    - Only catch specific exceptions like `IllegalArgumentException` or `IllegalStateException`.
