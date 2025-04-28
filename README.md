# kotlin-lotto-precourse

A simple lotto game where users purchase tickets, input winning numbers, and see if they’ve won based on match criteria and prize ranks.

## Features list
### Input
- User input purchase amount:
  - [ ] Each ticket costs 1000, so the amount must be divisible by 1000
  - [ ] Amount must be positive number
  - [ ] If the user inputs invalid data, print error message and re-prompt input from that step
  - [ ] If input's data is invalid, the program must throw an IllegalArgumentException
- User input winning numbers and a bonus number:
  - [ ] The winning numbers consist of 6 unique positive numbers comma-separated
  - [ ] The bonus number is a single, separate positive number 
  - [ ] If the user inputs invalid data, print error message and re-prompt input from that step
  - [ ] If input's data is invalid, the program must throw an IllegalArgumentException
### Lotto
- Issue lottery tickets:
  - [ ] Determine amount of tickets, divide purchase amount by 1000
  - [ ] Each ticket consist of 6 unique positive number
- Determine winnings tickets:
  - [ ] Compare each ticket with winning numbers and set winning tickets according to criteria
  - [ ] Calculate return money ratio
### Output
- Error message:
  - [ ] Error message starts with prefix [ERROR]
- Issued tickets:
  - [] Number of tickets issued and their numbers sorted in ascending order
- Lotto result statistic:
  - [ ] Print list all prize ranks and how many tickets are such rank
  - [ ] Total return rate. Rate rounded to the nearest tenth