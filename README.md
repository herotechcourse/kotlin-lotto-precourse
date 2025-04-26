# Lotto

## Flow (View)

1. Input purchase amount for buy the lottery tickets.
2. Print purchased lottery tickets with issued numbers (sorted)
3. Input last week's numbers
4. Input a bonus number.
5. Print lotto result statistics.
6. Print calculated Profit rate.

example:
```text
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

## Feature Planning

1. Input purchase amount for buy the lottery tickets.
    - issue lottery tickets you can purchase.
    - the lottery tickets contains 6 numbers of 1-45 and each is unique.
2. Print purchased lottery tickets with issued numbers (sorted)
    - output each sorted numbers of lottery tickets
3. Input last week's numbers
4. Input a bonus number.
   - compare last week's number with purchased every lottery tickets
5. Print lotto result statistics.
   - calculate lotto number matches. and print prize KRW
6. Print calculated Profit rate.
   - calculate used profit rate.
