# Best Time to Buy and Sell Stock
Say you have an array for which the $i$th element is the price of a given stock on day $i$. Design an algorithm to find the maximum profit. You may complete at most $k$ transactions.

**Note**:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

## First thought

Is brute-force a possible solution? 

The complexity would be $\binom{n}{2k}$. Exponential time. Bad bad bad!


Donâ€™t do redundant computation. So record the result. The next question is: Is a one-dimension array enough? It should NOT be enough. So a 2-dimensional array is necessary. 

So we need to use dynamic programming.

##Dynamic Programming

The key to solve the problem is to decide the structure of the array. 