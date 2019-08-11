package leetcode.problem2;

public class Jayden {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        printListNode(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currNode = null;
        ListNode resultNode = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            int currVal = sum % 10;

            carry = sum / 10;

            if (resultNode == null) {
                currNode = new ListNode(currVal);
                resultNode = currNode;
            } else {
                currNode.next = new ListNode(currVal);
                currNode = currNode.next;
            }

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }

        return resultNode;
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }

        printListNode(listNode.next);
        System.out.print(listNode.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
