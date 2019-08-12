# Acme Bank Smart-Save TDD Exercise (1 hour coding + 20 min Q&A)

Acme Retail Bank is building a Smart-Save feature to their bank account app that allows an existing loyalty card customer to deposit and withdraw funds to a Smart-Save bank account at the till.  This allows our customers to “Save as they go”, and for our customers to access cash back from their savings at the till if needed.

Your task as the lead developer in the team is to implement a straw-man solution using Java with for the new Smart Save account.  

## Smart-Save API Requirements 

##The functional sprint
Account
- register
- deposit cash
- withdraw cash
- fast balance

Statement query
- Date, transaction type, transaction amount, rolling balance

##Developer Rules
- Must use a strict TDD process
- Must not use abbreviations
- Must apply SOLID principles
- Must keep all objects small, highly cohesive and isolated
- Must use dependency inversion 
- Should use lamda programming style where appropriate
 

### The product owner has given the following acceptance test for statement printing
```
Given a customer makes a deposit of 1000 on 10-01-2019
And a deposit of 2000 on 13-01-2019
And a withdrawal of 500 on 14-01-2019
When she prints her bank statement
Then she would see
date       || credit     || debit      || balance
14/01/2019 ||            || 500.00     || 2500.00
13/01/2019 || 2000.00    ||            || 3000.00
10/01/2019 || 1000.00    ||            || 1000.00
```

### The product owner has given the following acceptance test for the API

```
Given a SmartSave account registration request 
When the request contains a valid customerId and customer-auth-token 
Then a new account is created and the accountId of the new account returned.
```

```
Given a newly created SmartSave account
When a second request to create the account is received for the same customer 
Then it should return the existing SmartSave accountId. 
```

```
Given a newly created SmartSave account 
When the opening balance is queried 
Then it should return 0.00
```

```
Given a newly created SmartSave account 
When a deposit of 120.22 is made 
Then the balance should return 120.22
```

```
Given a newly created SmartSave account 
When a withdrawal of 20.22 is requested 
Then a BadRequest exception should be returned stating “Insufficient funds available”
```

```
Given a newly created SmartSave account with a deposit of 20.22 and a subsequent withdrawal of 10.00GBP 
When the balance is queried 
Then it should return 10.22
```

```
Given a newly created SmartSave account 
When multiple deposits and withdrawals are made in random order 
Then the account balance should be returned correctly
```
 
#### Proposed strawman software architecture

![Architecture](./architecture.png?raw=true "Architecture Strawman")
 
Starter Project

- A starter project has been prepared for you, with the necessary Spring Boot and Reactor dependencies. 
