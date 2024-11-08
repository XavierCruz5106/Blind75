# Buy And Sell Stock

### https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

## First Solution

### Intuition

I initally started with both the min and max set to `Integer.MAX_VALUE` and `Integer.MIN_VALUE` respectively. My though process here was if i can iterate through the array and check if the current index is greater than max then thats the new max and vice versa if the current index is less than min thats the new minimum. However this introduced a bunch of issues and edge cases i didnt account for. I shortly scrapped that idea. My next idea i had was to just keep track of the min. We can iterate over the array and just like ive done before if the current index is less than the min than thats the new min. This time instead of calculating a max, i calculate the profitPotential which is potientially the amount of profit you can make. After doing this i realized if that profitPotential is greater than the current profit well we can update the current profit.
This solution WORKS! it was accepted by LeetCode.

### Approach

Mentioned Above.

`My next idea i had was to just keep track of the min. We can iterate over the array and just like ive done before if the current index is less than the min than thats the new min. This time instead of calculating a max, i calculate the profitPotential which is potientially the amount of profit you can make. After doing this i realized if that profitPotential is greater than the current profit well we can update the current profit.`

### Complexity

- Time Complexity
  $$O(n)$$
  The time complexity is $$O(n)$$ because we are only iterating over the array one time

- Space Complexity
  $$O(1)$$
  The space complexity is $$O(1)$$ because we are only ever initalizing 3 variables no matter what the input is

### Code

```java
int profit = 0;
int min = Integer.MAX_VALUE;

for (int i = 0; i < prices.length; i++){
    if (prices[i] < min) {
        min = prices[i];
    }

    int profitPotential = prices[i] - min;

    if (profitPotential > profit) {
        profit = profitPotential;
    }
}


return profit;
```

## SecondSolution

### Intuition

After i got done the second solution i figured the Math.max might be an interesting thing to use in this solution. So i got to thinkning about how i would incorporate Math.max. i came to the conclusion that if i set the inital buyPrice to the first element and then check to see if that buyPrice is greater than any other prices. (Essentially checking if there is a lower price to buy at). I could then use Math.max to get the max of the profit or the current element - buyPrice. This WORKS!!

### Approach

I implemented the above the logic by modifying the first solution a bit

### Complexity

- Time Complexity
  $$O(n)$$
  The time complexity is $$O(n)$$ because we are iterating over the prices once

- Space Complexity
  $$O(1)$$
  The space complexity is $$O(1)$$ because we are not allocating more space given more input

### Code

```java
int profit = 0;
int buyPrice = prices[0];

for (int i = 1; i < prices.length; i++){
    if (buyPrice > prices[i]){
        buyPrice = prices[i];
    }

    profit = Math.max(profit, prices[i] - buyPrice);
}


return profit;
```

## ThirdSolution

### Intuition

After implmenting my SecondSolution i wanted to keep that solution without using Math.Max this time

### Approach

In order to 'remove' Math.max i just checked if the element at i - the buyPrice is greater than the profit if so i update the profit.

### Complexity

- Time Complexity
  $$O(n)$$
  The time complexity is $$O(n)$$ because we are iterating over the array once

- Space Complexity
  $$O(n)$$
  The space complexity is $$O(1)$$ because we are not allocating new space based on input

### Code

```java
int profit = 0;
int buyPrice = prices[0];

for (int i = 1; i < prices.length; i++) {
    if (prices[i] < buyPrice) {
        buyPrice = prices[i];
    }
    else if (prices[i] - buyPrice > profit) {
        profit = prices[i] - buyPrice;
    }
}


return profit;

```
