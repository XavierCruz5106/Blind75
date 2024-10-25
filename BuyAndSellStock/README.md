# Two Sum

### https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

## First Solution

### Intuition

I initally started with both the min and max set to `Integer.MAX_VALUE` and `Integer.MIN_VALUE` respectively. My though process here was if i can iterate through the loop and check if the current index is greater than max then thats the new max and vice versa if the current index is less than min thats the new minimum. However this introduced a bunch of issues and edge cases i didnt account for. I shortly scrapped that idea. My next idea i had was to just keep track of the min. We can iterate over the loop and just like ive done before if the current index is less than the min than thats the new min. This time instead of calculating a max, i calculate the profitPotential which is potientially the amount of profit you can make. After doing this i realized if that profitPotential is greater than the current profit well we can update the current profit.
This solution WORKS! it was accepted by LeetCode.

### Approach

Mentioned Above.

`My next idea i had was to just keep track of the min. We can iterate over the loop and just like ive done before if the current index is less than the min than thats the new min. This time instead of calculating a max, i calculate the profitPotential which is potientially the amount of profit you can make. After doing this i realized if that profitPotential is greater than the current profit well we can update the current profit.`

### Complexity

- Time Complexity
  $$O(n)$$
  The time complexity is $$O(n)$$ because we are only going over the loop one time

- Space Complexity
  $$O(1)$$
  The space complexity is $$O(1)$$ because we are only ever initalizing 3 variables no matter what the input is


