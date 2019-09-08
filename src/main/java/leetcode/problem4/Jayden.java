package leetcode.problem4;

import java.util.ArrayList;
import java.util.List;

public class Jayden {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numbers = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                numbers.add(nums2[j++]);
            } else {
                numbers.add(nums1[i++]);
            }
        }

        while (i < nums1.length) {
            numbers.add(nums1[i++]);
        }

        while (j < nums2.length) {
            numbers.add(nums2[j++]);
        }

        int twoArrayLength = numbers.size();

        if (twoArrayLength % 2 == 0) {
            return (numbers.get((twoArrayLength / 2) - 1) + numbers.get(twoArrayLength / 2)) / 2.0;
        }

        return numbers.get(twoArrayLength / 2);
    }
}
