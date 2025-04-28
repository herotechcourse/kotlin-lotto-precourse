## Features
### Lotto
- Issue a lottery ticket
  - Each ticket consists of 6 unique random numbers
  - The numbers must be in the range from 1 to 45
  - The numbers are sorted in ascending order
- Check the lottery winning status
  - 1st Prize: Match 6 numbers / 2,000,000,000 KRW
  - 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
  - 3rd Prize: Match 5 numbers / 1,500,000 KRW
  - 4th Prize: Match 4 numbers / 50,000 KRW
  - 5th Prize: Match 3 numbers / 5,000 KRW
- Calculate the profit rate
  - Profit rate is calculated by dividing the prize by the purchase amount.
  - Profit rate rounded to the nearest tenth

### Input/Output
- Receive the winning numbers
  - The winning numbers consist of 6 unique numbers
- Receive a bonus number
  - The bonus number is a single, separate number
- Display the randomly issued lotto tickets
- Display the winning statistics
- Display the profit rate

### Exception
- Throw an exception if purchase amount is not a number
- Throw an exception if purchase amount is not divisible by 1,000
- Throw an exception if winning numbers contain non-numeric values
- Throw an exception if winning numbers are out of valid range
- Throw an exception if bonus number is not a number
- Throw an exception if bonus number is duplicated in winning numbers
- Throw an exception if bonus number is out of valid range