# kotlin-lotto-precourse

## Project Introduction

- This project implements a simple lottery ticket machine.
- Users can purchase lottery tickets based on their input amount, enter winning numbers and bonus number, and view the
  lottery results along with their profit rate.

## Feature List

| Status  | Feature                                                                           | Layer    |
|---------|-----------------------------------------------------------------------------------|----------|
| &#9745; | Input purchase amount                                                             | view     |
| &#9745; | Validate purchase amount                                                          | business |
| &#9745; | Issue lotto tickets                                                               | business |
| &#9745; | Output issued tickets sorted ascending                                            | view     |
| &#9745; | Input last week's winning numbers and bonus number                                | view     |
| &#9745; | Validate winning numbers and bonus number                                         | business |
| &#9745; | Compare user's tickets to winning numbers and bonus number                        | business |
| &#9745; | Calculate rank counts and profit rate                                             | business |
| &#9745; | Print result including winnings and profit rate                                   | view     |
| &#9745; | If error is thrown, re-prompt input from that step                                | shared   |
| &#9744; | Business logic unit test                                                          | test     |
| &#9745; | Throw error if purchase amount is not a number                                    | business |
| &#9745; | Throw error if purchase amount is not divisible by 1,000                          | business |
| &#9745; | Throw error if winning numbers contain non-numeric input                          | business |
| &#9745; | Throw error if winning numbers are not between 1 and 45                           | business |
| &#9745; | Throw error if winning numbers contain duplicates                                 | business |
| &#9745; | Throw error if bonus number is not between 1 and 45 or duplicates winning numbers | business |

## Limitations & Assumptions

1. **Program stays alive after any `IllegalArgumentException`;** it prints `[ERROR] …` and re-prompts the current step
   only.
2. Winning numbers input must meet all of the following conditions.
    - No empty values are allowed.(blank input is not valid).
    - All inputs must be valid numbers.
    - Each number must be between 1 and 45.
    - Duplicate numbers are not allowed.
