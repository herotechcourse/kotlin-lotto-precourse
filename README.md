# Lotto Game - Feature Planning

This document outlines the planned features for the Lotto Game application before implementation.

## Core Features

1. **Lotto Ticket Purchase**
   - Accept user input for purchase amount
   - Validate that purchase amount is divisible by 1,000 KRW (price of one lotto ticket)
   - Calculate number of tickets based on purchase amount

2. **Lotto Number Generation**
   - Generate random lotto tickets with 6 unique numbers (1-45)
   - Ensure no duplicate numbers within a single ticket
   - Display purchased lotto tickets to the user

3. **Winning Number Input**
   - Accept user input for 6 winning numbers
   - Validate that winning numbers are unique and within range
   - Accept user input for bonus number
   - Validate that bonus number is not among winning numbers

4. **Prize Calculation**
   - Match user tickets against winning numbers
   - Calculate prize tiers based on match count:
     - 1st Prize: 6 matches (2,000,000,000 KRW)
     - 2nd Prize: 5 matches + bonus ball (30,000,000 KRW)
     - 3rd Prize: 5 matches (1,500,000 KRW)
     - 4th Prize: 4 matches (50,000 KRW)
     - 5th Prize: 3 matches (5,000 KRW)

5. **Statistics Display**
   - Show count of winning tickets by prize tier
   - Calculate total winnings
   - Calculate return on investment (ROI)
