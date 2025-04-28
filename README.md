# kotlin-lotto-precourse
# Lotto
This program is simple lottery ticket machine

## Features
### 1. Ticket Purchase
- Enter the purchase amount for lottery tickets
- Each ticket costs 1,000 KRW (purchase amound must be divisible by 1,000)
- Generate random lottery tickets (range from 1 to 45, 6 unique number, sorted in ascending order)
- Display all purchased tickets to the user

### 2. Winning Numbers
- Allow users to enter the winning lottery numbers
- Range from 1 to 45, 6 unique number
- Bonus number is a single, seperate number

### 3. Prize Calculation
- Five ranks : 
  - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
  - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
  - 3rd Prize: Match 5 numbers / 1,500,000 KRW
  - 4th Prize: Match 4 numbers / 50,000 KRW
  - 5th Prize: Match 3 numbers / 5,000 KRW

### 4. Display result
- Display compares the user's each tickets to the winning numbers
- Display profit rate
