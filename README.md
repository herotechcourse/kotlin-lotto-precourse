# kotlin-lotto-precourse

1. Purchasing Lottery Tickets

- User inputs a purchase amount, validate that the amount is divisible by 1,000 KRW.
- Issue the correct number of tickets based on the amount, each ticket consists of 6 unique random numbers between 1 and 45.

2. Displaying Purchased Tickets

- Print all issued tickets sorted in ascending order.
- Show the number of tickets purchased.

3. Entering Winning Numbers

- User inputs 6 winning numbers (comma-separated).
- Validate that the numbers are:
  Unique, In the range 1 to 45
- User inputs a bonus number:
  between 1 and 45 and Is not duplicated among the winning numbers.

4. Comparing Tickets to Winning Numbers

- Check each ticket against the winning numbers.
- Determine the number of matches per ticket.
- Check for bonus number matches when there are 5 winning number matches.

5. Calculating Results
Categorize results into 5 prize ranks:
6 matches → 1st prize
5 matches + bonus → 2nd prize
5 matches → 3rd prize
4 matches → 4th prize
3 matches → 5th prize
Display how many tickets achieved each rank.

6. Calculating Profit Rate

Calculate total winnings.
Calculate profit rate = (total winnings / purchase amount) × 100.
Display profit rate rounded to one decimal place.

7. Error Handling

Throw IllegalArgumentException for:
Invalid purchase amount (not divisible by 1,000).
Invalid numbers (not between 1 and 45, not unique).
Error messages must start with [ERROR].


8. Coding Style Requirements

Keep functions under 10 lines.
Limit nesting to 2 levels.
Prefer early returns over else statements.
Separate business logic and UI (use InputView and OutputView).
Use Enums for rank and prize-related logic.
No use of System.exit() or exitProcess().
No modification of the provided build.gradle.kts file.

9. Testing

Write unit tests using JUnit5 and AssertJ.
Test business logic thoroughly (excluding UI code).