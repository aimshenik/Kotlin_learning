package selfeducation.leetcode.javasolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class App00 {
    public static void main(String[] args) {
        long nano1 = System.nanoTime();
        int[] result = twoSum(arr, target);
        long nano2 = System.nanoTime();
        long diff = nano2 - nano1;
        System.out.println("Variant1 : NANOS TAKEN IS " + diff + " and RESULT = " + Arrays.toString(result));

        nano1 = System.nanoTime();
        result = twoSum2(arr, target);
        nano2 = System.nanoTime();
        diff = nano2 - nano1;
        System.out.println("Variant2 : NANOS TAKEN IS " + diff + " and RESULT = " + Arrays.toString(result));
    }

    private static final int[] arr = new int[1_000];
    private static final int target = 1_000_100;
    private static final int iShouldBe = 1000;
    private static final int jShouldBe = arr.length-1;
    static {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = i;
        }
        arr[jShouldBe] = target + iShouldBe;
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i) return new int[]{i, map.get(x)};
        }
        return null;
    }
}

