Given an array of values that describe the historic data of stock prices, what would hypothetically
be the most that you could make if you were to sell 1 stock within the time period provided?

Mathematically stated, what is the maximum value of 
A[j] - A[i] where 0 <= i < j < n, in the array A.

Both algorithms provided in this folder are O(n) runtime O(1) stackspace.
one is a divide and conquer solution.
the other is a dynamic programming solution.

As implemented right now, neither report which indices to select in particular to achieve
this maximum profit, but both can be easily modified to do so.
