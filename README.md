# Lotto Game

First, the user should enter the amount of lotto tickets money. Each ticket costs 1,000 KRW.
- The amount should be a positive number and divisible by 1,000.
- Create tickets by using Random library.
- Each ticket should contain 6 unique numbers between 1 and 45.
- Display the tickets.

Next step, the user should enter the winning numbers.
- Numbers should be unique and between 1 and 45.

Next step, the user should enter one bonus number.
- The bonus number should be different from the winning numbers.

Calculate the winning tickets and the profit rate.
- Add Rank enum.
- For each ticket:
  - Count how many numbers match the winning numbers.
  - Check if the ticket has the bonus number.
- Introduce a map to keep which tickets has winning and their counts.
- Calculate the rank for each ticket based on matching numbers and bonus number.

Lastly, display results,
- Display the statistics of winning tickets for each rank.
- Display the profit rate.