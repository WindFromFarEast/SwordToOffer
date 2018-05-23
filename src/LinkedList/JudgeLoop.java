package LinkedList;

//判断链表成环
public class JudgeLoop {

    /**
     * 思路
     * 使用两个指针指向链表头部,同时开始遍历,让A指针一次走两步,B指针一次走一步,若A、B指针发生了相遇,说明链表成环
     * 若A遍历完了整个链表，说明链表不成环
     */
    public boolean isLoopLinkedList(ListNode pHead) {
        if (pHead == null) {
            return false;
        }
        ListNode pointA = pHead;//指针A
        ListNode pointB = pHead;//指针B
        while (pointA != null) {
            //指针A一次走两步,指针B一次走一步
            pointA = pointA.next.next;
            pointB = pointB.next;
            //判断两指针是否相遇
            if (pointA == pointB) {
                //两指针相遇,成环
                return true;
            }
        }
        return false;
    }

    private class ListNode {

        public int value;
        public ListNode next = null;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
