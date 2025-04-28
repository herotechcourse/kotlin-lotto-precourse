# kotlin-lotto-precourse
## Goals

### Learning Objectives

- Group related functions into classes so that objects collaborate to perform a larger feature.
- Write unit tests for each class and function to ensure they work as intended.
- Incorporate as much of the [Feedback on Pre-course Week 1](https://docs.google.com/document/d/1MXczCggC5-mYRzbgcAIDVec4xaTMojIh3vHLGwhTMgQ/edit?usp=sharing) as possible.

### Feedback by Pre-course and retrospect(in my occasion)
- [ Retrospect ] Write Feature lists by role and behavior.
- [ Feedback ] After carefully analyzing the requirements, features are derived and organized based on the results of the analysis.
- [ Feedback ] Feature must be written as small as possible.
- [ Retrospect ] After implementing each features, write test codes that can verify the feature.

## UML Object Design
### First Design
Below is the class diagram representing the object-oriented structure of the Lotto mission.
![lotto-precourse-uml](/docs/lotto-precourse.drawio.png)

### Advanced Design
![lotto-precourse-uml](/docs/lotto-precourse_1.drawio.png)

### Advanced Design2
![lotto-precourse-uml](/docs/lotto-precourse_2.drawio.png)

### Final Design
![lotto-precourse-uml](/docs/lotto-precourse_3.drawio.png)

## Feature list

### 1. Purchase and Ticket Generation
- [x] Receive the purchase amount from the user.
  - [x] If the amount is not divisible by 1,000, throw an exception and prompt for input again.
  - [x] If the amount is not positive, throw an exception and prompt for input again.
- [x] Calculate how many lottery tickets can be purchased with the given amount.
- [x] Generate N lottery tickets.
  - [x] Each ticket must consist of exactly 6 unique numbers between 1 and 45.
  - [x] When displaying ticket numbers, they must be sorted in ascending order.

### 2. Winning Numbers and Bonus Number Input
- [x] Receive 6 winning numbers from the user.
  - [x] Winning numbers must not contain non-numeric values.
  - [x] Winning numbers must be 6 numbers.
  - [x] Winning numbers must not contain duplicates.
  - [x] Winning numbers must be within the valid range (1–45).
- [x] Receive 1 bonus number from the user.
  - [x] The bonus number must be within the valid range (1–45).
  - [x] The bonus number must not overlap with any of the winning numbers.
- [x] Represent the winning numbers and bonus number as independent validated value objects.

### 3. Matching and Ranking
- [x] Compare each lottery ticket to the winning numbers and count how many numbers match.
  - [x] If a ticket matches exactly 5 numbers, check whether the ticket also matches the bonus number.
- [x] Determine the result (prize rank) for each ticket based on the number of matches and bonus number match.
- [x] Aggregate the number of tickets for each prize rank.
  - [x] Represent the prize results and counts using a structured result object.

### 4. Statistics and Return Rate
- [x] Calculate the total return rate.
  - [x] Return rate = (total prize money / total purchase amount) × 100.0, rounded to one decimal place.
- [x] Print the winning statistics and the return rate.