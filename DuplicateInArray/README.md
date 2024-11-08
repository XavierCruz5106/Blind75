# Duplicate In Array

### https://leetcode.com/problems/contains-duplicate/description/

## Map Method

### Intuition
When i read this problem i realized since a map cant contain any duplicates i can store each number in the map along with their matching occurrences and check if any number in the map has more than one occurrence.

### Approach
When writing down my first solution i noticed that if i just add the keys to the map, then check if the key already exists in the map then i know there is a duplicate. Therefore i did not 'finish' the previous implementation

### Complexity
* Time Complexity
$$O(n)$$
The time complexity is $$O(n)$$ because we only loop through the input one time

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because in the worst case the hashmap has to fill all the way up with n input.

### Code

```java
Map<Integer, Integer> mapOfOccurances = new HashMap<>();

for (int i = 0; i < nums.length; i++){
  if (mapOfOccurances.containsKey(nums[i])){
      return true;
  }

  mapOfOccurances.put(nums[i], i);
}

return false;
```


## Set Method

### Intuition
Instead of using a HashMap i switched over to a set because a set cannot contain duplicates and since i am not using the values and just the key in the hashmap a set can be used here.

### Approach
Same exact approach as the hashmap solution however instead of using a hashmap i used a set.

### Complexity

* Time Complexity
$$O(n)$$
The time complexity is $$O(n)$$ because we are looping through all of the input

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because worst case scenario is there are no duplicates

### Code

```java
Set<Integer> setOfOccurances = new HashSet<>();

for (int i = 0; i < nums.length; i++){
  if (setOfOccurances.contains(nums[i])){
      return true;
  }

  setOfOccurances.add(nums[i]);
}

return false;
```


## Array Method

### Intuition
I wanted to use the array given to solve the problem and not add more space so i decided to first sort the array so if there are any duplicates in the array they will be directly next to each other. Using this information i am able to check the current index and the next index and compare them. Now normally this would require 2 loops however i really did not want to have a $$O(n^2)$$ time so i found a sneaky way to do it with one loop.

### Approach
I first started by sorting the array. After ive sorted it i start to iterate from nums.length - 1 down to 1. I specifically choose one because using i, i can get both the current index and the next index by doing nums[i] for current and nums[i-1] for the next index. After getting these 2 elements i compare them to see if they are equal or not. if they are i return true. if we get through the whole loop i return false.

### Complexity

* Time Complexity

$$O(n log n)$$

The time complexity is $$O(n log n)$$ because java using the TimSort algorithm in order to sort the array.

* Space Complexity

$$O(n)$$

The space complexity is $$O(n)$$ because the TimSort algorithm requires extra space to sort.
