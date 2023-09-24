## Installation
Clone the Github repository [here](https://github.com/adeyatz/cinnamon-cinema)

## To run
Build the application, then from Main.java, run main.java, of hit Shift f10

## The results  
In the console window the following results are displayed:

+ The number of seats in Cinema in rows and seats per row
+ A list of empty seats, created at the start
+ A loop of random ticket requests (between 1 and 3) and the allocated seats for each request
+ The failed request that terminates the application, displaying the number of tickets requested
+ Finally a list of unallocated seats (if any) at the end of the run


## Assumptions
+ Rows above 26 are not supported
+ If 0 or less, or 4 or more seats are requested then the request is ignored
+ Asking for a seat plan containg 0 or fewer rows, or 0 or fewer seats per row throws an exception


## Key features
The SeatPlanner interface allows for a list of seats to be generated in any particular order
In the SeatPlannerZigZag, Option2 described in this [PDF](docs/cinnamon cinema sketch.pdf) is
implemented, but other seat ordering could be implemented as required
The use of Functional style programming has been utilised as much as possible


## Future thoughts
Although there is currently no mechanism for a customer to select specific seats it would
be possible to implement this functionality by adding a method to the Cinema class
It should be possible to create a seat plan with more than 26 rows, maybe the rows go to AA for 27 etc

## Sample Console Output
`START  
Create cinema with 3 rows, 5 seats per row  
Empty Seats:  
A1  
A2  
A3  
A4  
A5  
B5  
B4  
B3  
B2  
B1  
C1  
C2  
C3  
C4  
C5  
Ticket Request Size:3  
A1  
A2  
A3  
Ticket Request Size:2  
A4  
A5  
Ticket Request Size:2  
B5  
B4  
Ticket Request Size:1  
B3  
Ticket Request Size:3  
B2  
B1  
C1  
Ticket Request Size:3  
C2  
C3  
C4  
Ticket Request Size:3  
Failed to get 3 seats  
Empty Seats Remaining:  
C5
END`  
