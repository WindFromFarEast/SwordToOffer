package Robust;

//链表中倒数第k个节点
public class KThNodeToTail {

    //根据头节点找到链表的倒数第k个节点
    public ListNode FindKthToTail(ListNode head,int k) {
        //代码的鲁棒性检查
        if (head == null || k == 0) {
            return null;
        }
        //用两个指针来遍历数组
        ListNode pointFront = head;//走在前面的指针,比后面的指针先走了k-1步
        ListNode pointBehind = head;//走在后面的指针
        //让走在前面的指针先走k-1步
        for (int i = 1; i <= k - 1; i++) {
            if (pointFront.next != null) {
                pointFront = pointFront.next;
            } else {
                return null;
            }
        }
        //之后两个指针一起走,直到走在前面的指针走到了链表尾端,此时走在后面的指针指向的就是倒数第k个节点
        while (pointFront.next != null) {
            pointFront = pointFront.next;
            pointBehind = pointBehind.next;
        }
        return pointBehind;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
