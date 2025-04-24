# kotlin-lotto-precourse

# Project
This project is a application that simulates a lottery ticket machine. The goal is to implement a program that allows the user to purchase lottery tickets, generate random numbers for each ticket, compare them against winning numbers, and calculate prizes and profit rates based on specific rules.


## Plan features

- **User Input**
    - [ ] Prompt the user to purchase lottery ticket(s) (1000 KRW per ticket)
    - [ ] Prompt the user to enter 6 winning numbers (comma-separated)
    - [ ] Prompt the user to enter bonus number

- **Input Validation**
    - [ ] Verify purchase amount is a positive integer divisible by 1000
    - [ ] Winning numbers: exactly 6 unique numbers (1-45 range)
    - [ ] Bonus number: single unique number (1-45 range, not in winning numbers)
    - [ ] Error handling with `[ERROR]` prefix messages
    - [ ] Re-prompt on invalid input

- **Ticket Generation**
    - [ ] Calculate how many lottery ticket(s) can be purchased with the given amount
    - [ ] Generate random lottery tickets with 6 unique random numbers (1-45 range)

- **Lottery Mechanics**
    - [ ] Compare ticket(s) numbers for winning numbers
    - [ ] Compare ticket(s) numbers for bonus number
    - [ ] Calculate profit rate

- **Lottery Display**
    - [ ] Display number of tickets purchased
    - [ ] Display each ticket each sorted in ascending order
    - [ ] Display winning statistics
        - [ ] Display prize list
        - [ ] Display number of winning ticket(s)
        - [ ] Display rounded profit rate

- **Test**
    - [ ] Purchase amount
    - [ ] Winning numbers
    - [ ] Bonus number
    - [ ] Ticket generation
    - [ ] Prize tier identification
    - [ ] Profit calculation