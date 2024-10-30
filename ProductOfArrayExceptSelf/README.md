# Product of Array Except Self

### https://leetcode.com/problems/product-of-array-except-self/description/


## Solution 1

### Intuition
Initially i approached this problem with hesitation mainly because i saw it was a medium level leetcode problem and we all know that those easy leetcode problems are liars sometimes. However i digress. I saw this issue and immediate thought of an o(n^2) solution where i would loop over the array of nums and in my inner loop i would check if i == j and if that is the case then id continue then do the product calculation.

### Approach
Thats what i did. I iterate over the loop and in my outer-loop i declare a variable called product and declare a new inner-loop. Inside of that inner loop i check if the indices are the same and if they are i continue the inner loop.


### Complexity

* Time Complexity
$$O(n^2)$$
The time complexity is $$O(n^2)$$ because i am iterating over the input twice.

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because we are creating an array with n length.

### Code

```java
int[] answer = new int[nums.length];
for (int i = 0; i < nums.length; i++){
    int product = 1;
    for (int j = 0; j < nums.length; j++){
        if (i == j){
            continue;
        }

        product *= nums[j];
    }
    answer[i] = product;
}
return answer;
```

## Solution 2

### Intuition
When i started thinking about another way to solve this problem i figured lets break it up into pieces.


### Approach
In order to break it up into pieces i initialize 3 arrays with length of n. First i start to build out my prefix array with the by setting the first element to 1 then multiplying the nums by the element at the previous index.

Then i by iterating from right to left. and do the opposite logic.

After that i do one final loop to populate the answer array and return that array.

### Complexity
* Time Complexity
$$O(n)$$
The time complexity is $$O(n)$$ because we are looping over the nums never passing the length

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because we are initializing all of our arrays with the length of n

### Code
```java
int n = nums.length;
int[] ans = new int[n];
int[] prefix = new int[n];
int[] suffix = new int[n];

prefix[0] = 1;
for (int i = 1; i < n; ++i){
    prefix[i] = prefix[i - 1] * nums[i - 1];
}

suffix[n - 1] = 1;
for (int i = n - 2; i >= 0; --i){
    suffix[i] = suffix[i + 1] * nums[i + 1];
}

for (int i = 0; i < n; ++i){
    ans[i] = prefix[i] * suffix[i];
}

return ans;
```

## Solution 3

### Intuition
After implementing the previous solution I realized that i definitely overcomplicated it. I wanted to find a simpler solution in order to solve solution.

### Approach
I initialize an answer array to be the length of nums. then i loop over the array from the left side and do multiplication

Next i loop from the right and calculate the product as well.

### Complexity
* Time Complexity
$$O(n)$$
The time complexity is $$O(n)$$ because we are only looping until the length of nums

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because we are initializing a new array with the length of nums.

### Code
```java
int[] answer = new int[nums.length];
int product = 1;

for (int i = 0; i < nums.length; i++) {
    answer[i] = product;
    product *= nums[i];
}
product = 1;

for (int i = nums.length - 1; i >= 0; i--) {
    answer[i] *= product;
    product *= nums[i];
}

return answer;
```
