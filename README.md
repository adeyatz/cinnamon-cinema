## Installation
Clone the Github repository [here](http:/github.com/adeyatz/cinnamon-cinema)

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


## Approach

## Key features
The SeatPlanner interface allows for a list of seats to be generated in any particular order
In the SeatPlannerZigZag, Option2 described in this [PDF](docs/cinnamon cinema sketch.pdf) is
implemented, but other seat ordering could be implemented as required
The use of Functional style programming has been utilised as much as possible


## Future thoughts
Although there is currently no mechanism for a customer to select specific seats it would
be possible to implement this functionality by adding a method to the Cinema class


