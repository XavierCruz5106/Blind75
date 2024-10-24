package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static int[] twoSumMap(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if (map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }


    public static int[] twoSumNestedLoop(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    public static int[] twoSumPointer(int[] nums, int target) {
        for(int lp = 0; lp < nums.length; lp++){
            for (int rp = nums.length - 1; rp > lp; rp--)
            {
                if (nums[rp] + nums[lp] == target){
                    return new int[]{lp, rp};
                }
            }
        }
        return new int[]{};
    }




    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;


        int[] tsMapSol = twoSumMap(nums, 9);

        int[] tsNestedLoopSol = twoSumNestedLoop(nums, target);

        int[] tsPointerSol = twoSumPointer(nums, target);

        System.out.println("The Map solution for TwoSum is: " + Arrays.toString(tsMapSol));
        System.out.println("The Nested Loop solution for TwoSum is: " + Arrays.toString(tsNestedLoopSol));
        System.out.println("The Pointer solution for TwoSum is: " + Arrays.toString(tsPointerSol));

    }
}
