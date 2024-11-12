# Missing Number

### https://leetcode.com/problems/missing-number/description/

## Set Solution

### Intuition
I figured we could just all the expected numbers up to n to a set because n's max value is only 10_000

### Approach
I had to google a whole bunch of things we could do to a set and i found out that a HashSet has no get method. Kind of annoying but i found something called .iterator which allows us to get any element iteratively.

Using this newfound knowledge i started cracking down on the problem.

i first defined my set and added all the numbers up to N to my set.

after that i use the built in sort for arrays which is $$O(n log n)$$.

after sorting i instantiate my iterator and start looping over the array. for each loop i define a currentNum and the setNum we are checking against.

if the currentNum does not equal the setNum then we know that number in the set is the missing number and we return that.

for the edge case that the numbers up to n include 0, 1, 2 but the nums array only has 0, 1 in it i check to see if i is at its furthest point. and if it is then i return the next element in the set.

### Complexity
* Time Complexity
$$O(n log n)$$
The time complexity is $$O(n log n)$$ because Arrays.sort uses the dual-pivot quicksort algorithm which has a time complexity of $$O(n log n)$$.

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because im adding n integers to the set.

### Code

```java
Set<Integer> numsUpToN = new HashSet<>();

for (int i = 0; i <= nums.length; i++){
    numsUpToN.add(i);
}

Arrays.sort(nums);

Iterator<Integer> iterator = numsUpToN.iterator();
for (int i = 0; i < nums.length; i++){
  int currentNum = nums[i];
  int setNum = iterator.next();
  if (currentNum != setNum){
      return setNum;
  }
  iterator.remove();

  if (nums.length - 1 == i){

      return iterator.next();
  }
}

return -1;


```

## Optimized Set Solution

### Intuition
After writing the last set solution i began looking for ways i can optimize this. I realized that sorting the array was unnecessary because we are using a set.

Another inefficiency i found is iterating over the set while modifying the set at the same time can be inefficient.

### Approach

I started by deleting everything i had and starting over. I initialize my set and add all the numbers up to N like before.

Then instead of doing any comparison i use a foreach loop and loop over the nums array and for each num i remove it from the set. there is no case where the num does not exist in the set because the elements in the nums array are always between 0 and nums.length.

Then i just return the last element in the set which is the missing number

### Complexity

* Time Complexity
$$O(n)$$
The time complexity is $$O(n)$$ because we are adding n numbers to the set.

* Space Complexity
$$O(n)$$
The space complexity is $$O(n)$$ because we are adding n numbers to the set.

### Code
```java
Set<Integer> numsUpToN = new HashSet<>();
int n = nums.length;

for (int i = 0; i <= n; i++) {
  numsUpToN.add(i);
}

for (int num : nums) {
  numsUpToN.remove(num);
}

return numsUpToN.iterator().next();
```

## Math Solution

### Intuition
Leetcode kind of gave me a hint of what to look for. They suggested that i do it with $$O(n)$$ time complexity and in constant space. using this i was able to figure out a way to use math in order to find the missing number.

### Approach
i first wanted figure out how to get a sum of all the numbers up to n. after some googling i found this equation that does exactly that. `(n * (n + 1)) / 2` where `n = nums.length`.

Using this equation i can compare what we expect the sum to be vs what the sum actually is.

After comparing i was stuck for a bit i was wondering how do we get the missing number from this? I realized that if i just subtract what we expect vs what we got we get the missing number. for example if n = 4 we would add 0 + 1 + 2 + 3 + 4 which is 10. Then if nums has the numbers 0 + 1 + 3 + 4 that has a sum of 8. 10 - 8 is 2. thats the number we are missing!!


### Complexity
* Time Complexity
$$O(n)$$
The time complexity is $$O(n)$$ because we are looping over the array once.

* Space Complexity
$$O(1)$$
The space complexity is constant because we are not allocating any new space based on input.

### Code
```java
int n = nums.length;
int expectedSum = (n * (n + 1)) / 2;  // Sum of numbers from 0 to n
int actualSum = 0;

// Calculate the sum of the numbers in the array
for (int num : nums) {
    actualSum += num;
}

// The missing number is the difference between expected and actual sums
return expectedSum - actualSum;
```
