# kotlin-lotto-precourse

## Program Introduction

This is a lottery simulation program implemented in kotlin.

When you input your purchase amount (which must be divisible by 1,000 KRW) and specify the winning lotto numbers (+ bonus number), this program generates `purchase amount / 1,000` random lotto tickets. It then compares your tickets against the winning numbers and prints the results along with the total return rate.

### Example Execution

```bash
Please enter the purchase amount.
8000

You have purchased 8 tickets.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

Please enter last week's winning numbers.
1,2,3,4,5,6

Please enter the bonus number.
7

Winning Statistics
---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 62.5%.
```

## Feature List

### 1. Input Purchase Amount
- Receive the purchase amount
- The amount must be **divisible by 1,000**

### 2. Calculate Ticket Quantity
- The program issues (purchase amount / 1,000) lottery tickets

### 3. Generate Random Lotto Numbers
For each ticket:
- Consist of 6 unique random numbers
- Numbers must be in the range from 1 to 45

### 4. Print Issued Lotto Tickets
- Print the number of tickets: `You have purchased {amount} tickets.`
- Print each ticket: `[a,b,c,d,e,f]`

### 5. Input Winning Numbers
- Receive **6 unique numbers**
    - No repeated numbers allowed
- Each number must be in the range **from 1 to 45**
- Comma-separated **without spaces**
- If input is invalid, throw exception → Re-promt input from that step

### 6. Input Bonus Number
- Input a single, separate number (not overlapping with winning numbers)
- Each number must be in the range **from 1 to 45**
- If input is invalid, throw exception → Re-promt input from that step

### 7. Match lotto numbers
- Count how many numbers match the winning numbers.
- Check if the bonus number matches

### 8. Determine Prize Rank
- Decide the prize rank based on:
    - Number of matching numbers
    - Bonus number match

### 9. Count Prizes
- Count how many tickets correspond to each prize rank

### 10. Calculate Return Rate
- Sum all prize amounts
- Calculate the return rate (total prize/purchase amount)*100 → rounded to the nearest tenth

### 11. Output
- Print the number of matched tickets for each prize rank.
- Print the total return rate

### 12. Testing
- Unit tests using JUnit 5, AssertJ
