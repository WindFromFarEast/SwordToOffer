package LinkedList;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        //鲁棒性检查
        if (pHead == null) {
            return null;
        }
        //遍历链表的指针
        ListNode pNode = pHead;
        while (pNode != null) {

        }
        return pHead;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
