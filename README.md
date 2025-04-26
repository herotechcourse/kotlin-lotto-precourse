# kotlin-lotto-precourse

# Project
This project is a application that simulates a lottery ticket machine. The goal is to implement a program that allows the user to purchase lottery tickets, generate random numbers for each ticket, compare them against winning numbers, and calculate prizes and profit rates based on specific rules.


## Plan features

- **User Input**
    - [x] Prompt the user to purchase lottery ticket(s) (1000 KRW per ticket)
    - [x] Prompt the user to enter 6 winning numbers (comma-separated)
    - [x] Prompt the user to enter bonus number


- **Input Validation**
    - [x] Verify purchase amount is a positive integer divisible by 1000
    - [x] Winning numbers: exactly 6 unique numbers (1-45 range)
    - [x] Bonus number: single unique number (1-45 range, not in winning numbers)
    - [x] Error handling with `[ERROR]` prefix messages
    - [x] Re-prompt on invalid input


- **Ticket Generation**
    - [x] Calculate how many lottery ticket(s) can be purchased with the given amount
    - [x] Generate random lottery tickets with 6 unique random numbers (1-45 range)


- **Lottery Mechanics**
    - [x] Compare ticket(s) numbers for winning numbers
    - [x] Compare ticket(s) numbers for bonus number
    - [ ] Calculate profit rate


- **Lottery Display**
    - [x] Display number of tickets purchased
    - [x] Display each ticket each sorted in ascending order
    - [ ] Display winning statistics
        - [x] Display prize list
        - [x] Display number of winning ticket(s)
        - [ ] Display rounded profit rate


- **Test**
    - [x] Purchase amount
    - [x] Winning numbers
    - [x] Bonus number
    - [x] Ticket generation
    - [ ] Prize tier identification
    - [ ] Profit calculation