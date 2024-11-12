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

## Math Solution