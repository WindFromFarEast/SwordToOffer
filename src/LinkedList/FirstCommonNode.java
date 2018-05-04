package LinkedList;


//两个链表的第一个公共节点
public class FirstCommonNode {

    /**
     * 思路
     * 获得两个链表的长度,假设第一个长度为m,第二个长度为n,并且m > n
     * 那么先在第一个链表上走(m - n)步,再让两个链表同时遍历
     * 此时得到的第一个相同的节点就是公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //鲁棒性检查
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //得到两个链表的长度
        int lengthA = getLength(pHead1);
        int lengthB = getLength(pHead2);
        //两个链表长度的差值
        int difference = 0;
        //比较两个链表的长度
        if (lengthA > lengthB) {
            //链表A比链表B长
            difference = lengthA - lengthB;
            //先让链表A走difference步
            for (int i = 0; i < difference; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            difference = lengthB - lengthA;
            //先让链表B走difference步
            for (int i = 0; i < difference; i++) {
                pHead2 = pHead2.next;
            }
        }
        //同时遍历两个链表,找到第一个相同的节点
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        //判断两个链表是否到尾部都不存在相同节点
        if (pHead1 == null) {
            return null;
        }
        return pHead1;
    }

    //得到指定链表的长度
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
