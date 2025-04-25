# kotlin-lotto-precourse

---

## 🖍️ Description

A simple console-based application that simulates a lottery ticket machine. 
Users can purchase tickets with a specified amount, the program generates random ticket numbers, and users can then input winning numbers to check their results, including total winnings and return rate.

---

## ☑️ Feature List

1.  **Receive Purchase Amount**
    * Prompt the user: `Please enter the purchase amount.`
    * **Exception Handling:**
        * If the input is not a number.
        * If the input is a negative number.
        * If the input is a positive number less than 1000.
        * If the input is a positive number not a multiple of 1000.


2.  **Calculate Number of Tickets to Issue**
    * Calculate the number of tickets: `purchase amount // 1000`.
    * Print the number of tickets purchased: `You have purchased {} tickets.`

    
3.  **Generate Lottery Ticket Numbers**
    * For each purchased ticket, generate 6 unique random numbers.
    * Numbers must be in the range 1 to 45.
    * Print each ticket's numbers in the format: `[8, 21, 23, 41, 42, 43]`


4.  **Receive Winning Numbers**
    * Prompt the user: `Please enter last week's winning numbers.`
    * Input should be 6 comma-separated numbers.
    * **Exception Handling:**
        * If the input contains non-numbers.
        * If any number is not within the range 1 to 45.
        * If there are duplicate numbers.
        * If the input does not contain exactly 6 numbers.


5.  **Receive Bonus Number**
    * Prompt the user: `Please enter the bonus number.`
    * **Exception Handling:**
        * If the input is not a number.
        * If the number is not within the range 1 to 45.
        * If the number is one of the winning numbers.


6.  **Determine Winning Ranks and Prizes**
    * Compare each generated ticket's numbers with the winning numbers and the bonus number.
    * Determine the prize rank for each ticket based on the number of matches and the bonus number.
    * Output winning information by rank in order of (5th, 4th, 3rd, 2nd, 1st).
    * Print the results in the format: `3 Matches (5,000 KRW) – 1 tickets`


7.  **Calculate Statistics**
    * Calculate the total winnings from all tickets.
    * Calculate the total return rate: `(Total Winnings / Purchase Amount) * 100`.
    * Print the total return rate in the format: `Total return rate is 62.5%.`