# kotlin-lotto-precourse

## Description

A simple text-based lotto game built with Kotlin 1.9.24, with the aim of self-teaching kotlin. Users can winning numbers and the number of tickers bought. The program compares user-defined input winning numbers with arbitrary ticket numbers to determine a winning rate based on comparing winning numbers and ticket numbers. Multiple prize ranks can be acheived. All features are implemented in Kotlin 1.9.24 using only the provided standard libraries and APIs.

## Features

- User-defined purchase amount of lottery tickets (1,000 KRW each)
- 6 user-defined winning numbers (comma-separated) and 1 bonus number
- Multiple price ranks:
  * 1st Prize: Match 6 numbers / 2,000,000,000 KRW
  * 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
  * 3rd Prize: Match 5 numbers / 1,500,000 KRW
  * 4th Prize: Match 4 numbers / 50,000 KRW
  * 5th Prize: Match 3 numbers / 5,000 KRW
- Output of winning numbers and ticket numbers match, and profit rate (rounded to the nearest tenth)
- Fully implemented in Kotlin 1.9.24 
- Input validation with meaningful error handling (no exception calls)
- Unit tested
