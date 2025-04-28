# kotlin-lotto-precourse

### 1. Enter the Purchase Amount

- [x] Enter the `purchase amount` input
- Validation for Purchase Amount Input
    - [x] must be a **number**
    - [x] must **not exceed** the maximum limit
    - [x] must be a multiple of the **unit value(1,000 KRW)**

  `````````text
    Please enter the purchase amount.
    110000
    [ERROR] Purchase amount must not exceed 100000. Please enter again.
  
    Please enter the purchase amount.
    1000j
    [ERROR] This input must be a number. Please enter again.
  
    Please enter the purchase amount.
    [ERROR] This input must be a number. Please enter again.
    Please enter the purchase amount.

- [x] Calculate how may Lottery tickets to generate

### 2. Create Random Lotto

- [x] Generate `random Lottery tickets` based on the purchase amount
- Common Validation for Lotto
    - [x] Ensure exactly **six numbers** are selected
    - [x] Ensure **no duplicate** numbers exist
    - [x] Ensure all numbers are in a **valid range**
- [x] `Sort` the numbers in each Lotto ticket in **ascending order**
- [x] Print the generated Lotto

### 3. Enter the Winning Numbers

- [x] Enter the `winning numbers input`
- [x] input must not be **blank** or **empty**
- [x] Generate the winning Lotto ticket
    - [x] Common Validation for Lotto same as
        - [x] Ensure exactly **six numbers** are selected
        - [x] Ensure **no duplicate** numbers exist
        - [x] Ensure all numbers are in a **valid range**

    `````````text
      Please enter last week's winning numbers.
      d,la,s,sld
      [ERROR] This input must be a number. Please enter again.
      
      Please enter last week's winning numbers.
      1,2,3,4,5,6,7
      [ERROR] Numbers must contain exactly 6 numbers. Please enter again.
      
      Please enter last week's winning numbers.
      1,2,3,4,5,66
      [ERROR] Numbers must be between 1 and 45. Please enter again.

### 4. Enter the Bonus Number

- [x] Enter the `bonus number input`
    - [x] must be a **number**
    - [x] must not be **blank** or **empty**
    - [x] must not be duplicated in the winning numbers

  `````````text
    Please enter the bonus number.
    55
    [ERROR] Numbers must be between 1 and 45. Please enter again.
  
    Please enter the bonus number.
    1000
    [ERROR] Numbers must be between 1 and 45. Please enter again.

### 5. Find RankPrize

- [x] Count how many numbers match
- [x] Check if the bonus number is included
- [x] Determine the prize rank based on **match count** and **bonus match**
- [x] Count how many tickets won for each prize rank
- [x] Calculate `profit rate`

### 6. Print the Result

- Print the final result of the Lotto
    - [x] **Rank**(e.g, 1st, 2nd, 3rd...)
    - [x] **Prize amount** for that rank
    - [x] **Count** of winning tickets
- Print the profit rate
    - [x] Formatted value rounded to **two decimal places**
    - [x] Formatted numbers with commas as **'thousand' separators**

  ````text
    Winning Statistics
    ---
    3 Matches (5,000 KRW) – 0 tickets
    4 Matches (50,000 KRW) – 2 tickets
    5 Matches (1,500,000 KRW) – 0 tickets
    5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
    6 Matches (2,000,000,000 KRW) – 0 tickets
    Total return rate is 5,000.0%.

### 7. Re-enter

- [x] **Re-enter** input when entered an invalid value