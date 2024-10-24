package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public int[] twoSumMap(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if (indexMap.containsKey(diff)){
                return new int[]{indexMap.get(diff), i};
            }

            indexMap.put(nums[i], i);
        }
        return new int[]{};
    }


    public int[] twoSumNestedLoop(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    public int[] twoSumPointer(int[] nums, int target) {
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
}
