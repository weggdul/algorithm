package main.java.leetcode.problem2;

/**
 * algorithm
 *
 * @author wedul
 * @since 2019-08-11
 **/
public class Wedul {

    public static void main(String[] args) {
        // test
        int[] ret = twoSum(new int[]{2, 7, 11, 12}, 9);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }

        return ret;
    }

}
