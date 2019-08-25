package leetcode.problem4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * algorithm
 *
 * @author wedul
 * @since 2019-08-24
 **/
public class Wedul {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {-1, 3}));
        System.out.println(findMedianSortedArrays(new int[] {2}, new int[] {1, 3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        int array1Cursor = 0;
        int array2Cursor = 0;

        while (array1Cursor < nums1.length && array2Cursor < nums2.length) {
            if (nums1[array1Cursor] > nums2[array2Cursor]) {
                ret.add(nums2[array2Cursor++]);
            } else {
                ret.add(nums1[array1Cursor++]);
            }
        }

        int totalLength = nums1.length + nums2.length;
        int medianIndex = totalLength / 2;

        // 이미 정렬된 부분까지 값이 있을 경우
        if (ret.size() - 1  >= medianIndex) {
            if (totalLength % 2 == 0) {
                return (ret.get(medianIndex - 1) + ret.get(medianIndex)) / 2.0;
            } else {
                return ret.get(medianIndex);
            }
        } else {
            medianIndex = medianIndex - ret.size();
            if (array1Cursor < nums1.length) {
                return getMedianValue(ret, nums1, array1Cursor, array1Cursor + medianIndex, totalLength);
            } else {
                return getMedianValue(ret, nums2, array2Cursor, array2Cursor + medianIndex, totalLength);
            }
        }
    }

    private static double getMedianValue(List<Integer> ret, int[] nums, int cursor, int medianIndex, int totalLength) {
        if (totalLength % 2 == 0) {
            if (cursor == medianIndex) {
                return (ret.get(ret.size() - 1) + nums[medianIndex]) / 2.0;
            } else{
                return (nums[medianIndex - 1] + nums[medianIndex]) / 2.0;
            }
        } else {
            return nums[medianIndex];
        }
    }
}
