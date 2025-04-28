# kotlin-lotto-precourse

## feature list
### input handling
- [x] purchase amount
    - [x] validate that purchase amount is divisible by 1,000
    - [x] throw exception if purchase amount is not divisible by 1,000
- [x] 6 winning numbers + 1 bonus number
    - [x] all 7 numbers must be unique in the range from 1 to 45
    - [x] bonus number is a number separate from the winning numbers
### exception handling
- [ ] re-prompt user in case of exceptions
- [ ] start error message with [ERROR]
### lottery ticket machine
- [x] ticket generation
    - [x] generate number of tickets based on purchase amount - 1 ticket per 1,000
    - [x] each ticket consists of 6 random and unique numbers in the range from 1 to 45
- [x] result generation
    - [x] compare tickets with winning numbers to calculate winnings - see table below
    - [x] calculate profit return rate based on winnings
    - [x] round profit return rate to nearest tenth
### output
- [x] ask user for input
    - [x] ask user for purchase amount
    - [x] ask user for winning numbers
    - [x] ask user for bonus number
- [x] generated tickets
    - [x] number of tickets
    - [x] tickets
        - [x] numbers must be sorted in ascending order
- [x] results
    - [x] matches per prize rank
    - [x] profit return rate


## prize ranks
user wins based on matches
- 1st prize: 6 matching numbers --> 2,000,000,000 KRW
- 2nd prize: 5 matching numbers + bonus number --> 30,000,000 KRW
- 3rd prize: 5 matching numbers --> 1,500,000 KRW
- 4th prize: 4 matching numbers --> 50,000 KRW
- 5th prize: 3 matching numbers --> 5,000 KRW