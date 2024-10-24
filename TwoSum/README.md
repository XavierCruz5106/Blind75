# TwoSum
### https://leetcode.com/problems/two-sum/description/

## Nested Loop

### Intuition

My first thoughts were to iterate over the array twice. The first loop would check the current number and the second loop would check all the numbers afterwards.

### Approach
I first started with identifying what has to be done in order to solve the problem using 2 loops. I figured we have to have a way to store our output so i firstly initialized a int array. Given the problem I know that there will never be more than 1 valid answer. And each input would have exactly 1 solution. Keeping this in mind I first iterated over the array in order to check the number at index i to the number at index j (the number after nums[i]). I then compared the sum of those 2 numbers to the target and if they matched i added them to the sum array and returned it.

### Complexity
* Time complexity:
$$O(n^2)$$
The time complexity of this method is O(n^2) because we are iterating over the nums array twice.

* Space complexity:
$$O(1)$$
The space complexity of this method is O(1) or constant because no matter the input size we are always allocating space for an array of 2 elements.

### Code
```java

int[] sum = new int[2];
for (int i = 0; i < nums.length; i++){
  for (int j = i+1; j < nums.length; j++){
    if (nums[i] + nums[j] == target){
      sum[0] = i;
      sum[1] = j;
    }
  }
}
return sum;
```



## Bidirectional Method

### Intuition
After implementing the previous solution I wondered if going backward would be cool.

### Approach
I pretty much just copied and pasted my last solution but instead of iterating in the same direction i have the inner loop going the opposite direction so they meet up in the middle

### Complexity

* Time Complexity
$$O(n^2)$$
The time complexity is still O(n^2) because we are still going over the nums array twice

* Space Complexity
$$O(1)$$
The space we allocated did not change, we are still allocating an array of 2 elements

### Code

```java
int[] sum = new int[2];
for(int lp = 0; lp < nums.length; lp++){
  for (int rp = nums.length - 1; rp > lp; rp--)
  {
    if (nums[rp] + nums[lp] == target){
      sum[0] = lp;
      sum[1] = rp;
    }
  }
}
return sum;


```


## HashMap Method

### Intuition
After implementing the last 2 solutions I wondered if i can leverage a data structure to reduce my time complexity. I figured since a lookup in a hashmap is constant time i should be able to store any values i want to look up and compare which would bring my time complexity down to O(n)

### Approach

I start with initializing a new HashMap where the kvp's are both Integers, the direction i want to go is i store the number at index i as the key and i as the value. I do this to prevent me from having to lookup indexes in the map where i could just look up a number and get the index of that number. While implementing this method i realized that instead of adding the numbers up we can subtract them instead. Subtracting them allows us to do some pretty cool math tricks. Firstly it helps us to use unknown numbers to us, what i mean is we can determine that the target - the current number can be looked up in the map and if it exists we know for an absolute fact that we have the numbers needed to add up to the target.

### Complexity

* Time Complexity
$$O(n)$$
The time complexity is O(n) because we only ever go through the loop of nums 1 time.

* Space Complexity
$$O(n)$$
The space complexity is O(n) because in the worst case the HashMap will be full of every element in the nums array therefore the size of the map is proportional to the size of the nums array.

### Code

```java

int[] sum = new int[2];
Map<Integer, Integer> map = new HashMap<>()

for (int i = 0; i < nums.length; i++){
  int diff = target - nums[i];

  if (map.containsKey(diff)){
    sum[0] = map.get(diff);
    sum[1] = i;
  }

  map.put(nums[i], i);
}

return sum;
```