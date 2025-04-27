# kotlin-lotto-precourse

---
## Project Goal
- Compare the user's tickets to the winning numbers.
- Print the winnings and profit rate.
## Feature List
### Input
#### 1. Purchase amount
- [x] Prompt : "Please enter the purchase amount."
- [x] Enter the purchase amount
  - [x] If the amount isn't divisible by 1,000
    - [x] throw IllegalArgumentException
    - [x] re-prompt input 
#### 2. Ticket lists
- [x] Prompt : "You have purchased 8 tickets."
- [x] Make m(size of 6)*n(size of purchase amount/1000) lists
  - [x] Number : in range from 1 to 45
  - [x] Prompt : `m` length list for repeats `n`
#### 3. Last week's winning numbers.
- [x] Prompt : "Please enter last week's winning numbers."
    - [x] Enter the winning numbers
        - [x] If the numbers are not separated by commas
            - [x] throw _IllegalArgumentException_
            - [x] re-prompt input
        
#### 4. Bonus number
- [x] Prompt : "Please enter the bonus number."
  - [x] If the number isn't in the range of 1 to 45
      - [x] throw _IllegalArgumentException_
  - [ ] If input is not number
    - [ ] throw _IllegalArgumentException_
    
### Process
-[x] Compare Each of ticket lists with winning numbers and Match this prize amounts
  - 1st Prize (2,000,000,000 KRW) : Match 6 numbers 
  - 2nd Prize (30,000,000 KRW) : Match 5 numbers + bonus Number
  - 3rd Prize (1,500,000 KRW): Match 5 numbers 
  - 4th Prize (50,000 KRW): Match 4 numbers
  - 5th Prize (5,000 KRW): Match 3 numbers
-[x] Calculate profit rate
  - sum of prize amounts/the purchase amount*100

### Output
-[x] Prompt : "Winning Statistics"
-[x] Prompt : The result for each match  and amount the winning tickets
-[x] Prompt : "Total return rate is " with  profit rate

