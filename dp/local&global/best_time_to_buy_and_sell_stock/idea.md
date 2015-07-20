# Best Time to Buy and Sell Stock
Say you have an array for which the $i$th element is the price of a given stock on day $i$. Design an algorithm to find the maximum profit. You may complete at most $k$ transactions.

**Note**:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

## First thought

Is brute-force a possible solution? 

The complexity would be $\binom{n}{2k}$. Exponential time. Bad bad bad!


Don't do redundant computation. So record the result. The next question is: Is a one-dimension array enough? It should NOT be enough. So a 2-dimensional array is necessary. 

So we need to use dynamic programming.

##Dynamic Programming

The key to solve the problem is to decide the structure of the array. It is a classical example for *local optimum* and *global optimum*.

*Local optimum* indicates some the optimum solution including the current one. Global optimum is the optimum so far. So we can construct the DP arrays. 

```java
int[][] local = new int[len][k];
int[][] global = new int[len][k];
```
Every time we want to update the local optimum, there are two cases: 

 1. It is a transaction with buy-in at $i - 1$ and sell-out at $i$;
 2. It is a transaction with buy-in before $i - 1$ and sell-out at $i$.


So 
```java
int diff = price[i] - price[i - 1];
local[i][j] = Math.max(global[i - 1][j - 1] + diff, local[i - 1][j] + diff);
global[i][j] = Math.max(global[i - 1][j], local[i][j]);
```