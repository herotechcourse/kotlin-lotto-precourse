# Lotto 

A concise, testable CLI lotto game in Kotlin. Modular, readable and easy to test.

## Features

- **Clean architecture**
   - `lotto.domain`  
     – `Lotto`: immutable value object enforcing 6‐number, uniqueness and 1 – 45 range invariants in its `init`.  
     – `Rank`: enum encapsulating match+bonus logic and prize formatting via `from()` and `description()`.

   - `lotto.service`  
     – `TicketMachine` issues tickets; DI-friendly random number generator  
     – `Statistics` computes total prize and ROI (1 decimal)
  
   - `lotto.controller`  
     – `LottoController` orchestrates purchase → input → calculation → output
  
   - `lotto.view`  
     – `InputView` & `OutputView` isolate all Console I/O  
     – Re-prompt loops on invalid input; all errors start with `[ERROR]`
  
   - `lotto.util`  
     – `Config` holds constants (`TICKET_PRICE`, `LOTTO_NUMBER_COUNT`, `LOTTO_MIN_NUMBER`, `LOTTO_MAX_NUMBER`)  
     – `Messages` centralizes all prompts and formatted error messages
  

- **Ticket rules**  
  -  Purchase amount must be a multiple of `Config.TICKET_PRICE`  
  -  Each ticket: 6 unique numbers in `Config.LOTTO_MIN_NUMBER..Config.LOTTO_MAX_NUMBER`, sorted


- **Comprehensive tests**
  -  Unit tests for every core class (`Lotto`, `TicketMachine`, `Statistics`, `Rank`) covering happy paths and invalid inputs. 
  -  Boundary & edge-case tests (zero purchase, all losses, mixed prize categories).

## Example Run

```text
***** Welcome to Lotto *****

Each ticket costs 1000 KRW.

Please enter the purchase amount (must be multiple of 1000; for example 2000):
2000

============= Ticket Purchase Summary =============

You have purchased 2 tickets.
[5, 12, 23, 34, 36, 45]
[1, 8, 14, 19, 27, 33]

===================================================

Enter the 6 winning numbers (comma-separated):
1,2,3,4,5,6

Enter the bonus number:
7

*************** Lotto Winning Statistics ***************
6 Matches (2,000,000,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
4 Matches (50,000 KRW) – 0 tickets
3 Matches (5,000 KRW) – 0 tickets

Total return rate is 0.0%.
**********************************************************

### How to Test

```bash
./gradlew clean test
```

 All tests should pass successfully.
