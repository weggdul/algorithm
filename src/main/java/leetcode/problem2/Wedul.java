package main.java.leetcode.problem2;

/**
 * algorithm
 *
 * @author wedul
 * @since 2019-08-11
 **/
public class Wedul {

    public static void main(String[] args) {
        // problem 1
        int[] ret = twoSum(new int[]{2, 7, 11, 12}, 9);

        // problem 2
        ListNode list1 = new ListNode(2);
        ListNode list1_1 = new ListNode(4);
        ListNode list1_2 = new ListNode(3);

        list1.next =list1_1;
        list1_1.next = list1_2;

        ListNode list2 = new ListNode(5);
        ListNode list2_1 = new ListNode(6);
        ListNode list2_2 = new ListNode(4);

        list2.next = list2_1;
        list2_1.next = list2_2;

        ListNode ret2 = addTwoNumbers(list1, list2);
        System.out.println(ret2.val);

        ListNode list3 = new ListNode(5);
        ListNode list3_1 = new ListNode(5);
        ListNode ret3 = addTwoNumbers(list3, list3_1);
        System.out.println(ret3.val);

        ListNode list4 = new ListNode(1);
        ListNode list4_2 = new ListNode(8);
        list4.next = list4_2;

        ListNode list4_3 = new ListNode(0);
        ListNode ret4 = addTwoNumbers(list4, list4_3);
        System.out.println(ret4.val);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        for (int i = 0; i < nums.length; i++) {
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sumValue = 0;
        ListNode ret = null;
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode currNode = null;

        while (null != next1 || null != next2) {
            int val1 = 0;
            int val2 = 0;

            if (null != next1) {
                val1 = next1.val;
            }

            if (null != next2) {
                val2 = next2.val;
            }

            int sum = val1 + val2 + sumValue;
            int curValue = sum % 10;
            sumValue = sum / 10;

            ListNode node = new ListNode(curValue);
            if (null == ret) ret = node;
            else currNode.next = node;
            currNode = node;

            next1 = null != next1 ? next1.next : null;
            next2 = null != next2 ? next2.next : null;
        }

        if (0 != sumValue) {
            ListNode node = new ListNode(sumValue);
            currNode.next = node;
        }

        return ret;
    }

}
