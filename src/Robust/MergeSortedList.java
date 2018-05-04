package Robust;

//合并两个排好序的链表
public class MergeSortedList {

    //将排好序的链表list1和list2合并
    public ListNode merge(ListNode list1, ListNode list2) {
        //首先进行鲁棒性检查
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        //最终返回的合并链表头节点
        ListNode head = null;
        //每一步的操作都是首先判断头节点是否为空,若有一个为空则返回另一个头节点,若两者都不为空则返回较小的头节点,因此可以使用递归实现
        if (list1.val < list2.val) {
            head = list1;
            head.next = merge(list1.next, list2);
        } else {
            head = list2;
            head.next = merge(list1, list2.next);
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
