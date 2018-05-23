package LinkedList;

//链表有环，找到环的入口节点
public class EntryNodeOfLoop {

    /**
     * 思路
     * 一、确定环中的节点数，方式为设定两个指针A、B指向链表头部，B每次走两步，A每次走一步，
     * A、B第一次相遇必定是在环中的某一个节点，那么此时让A、B每次走一步，开始计数，下次回到这个节点时的计数就是环的节点数，假设为n
     * 二、再让A、B重新指向头部，让指针A先走n步，指针B不动，接着A、B以相同的速度遍历，A、B第一次相遇的节点就是环的入口节点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //判断链表是否有环
        if (!isLoopLinkedList(pHead)) {
            return null;//链表无环
        }
        //指针A、B
        ListNode pointA = pHead;
        ListNode pointB = pHead;
        //确定环的长度
        int loopLength = getLoopLength(pHead);
        //让指针A先走loopLength步
        for (int i = 0; i < loopLength; i++) {
            pointA = pointA.next;
        }
        //之后A、B每次走一步,第一次相遇的节点就是环的入口节点
        for (;;) {
            pointA = pointA.next;
            pointB = pointB.next;
            if (pointA == pointB) {
                break;
            }
        }
        return pointA;
    }

    //获取链表中环的长度
    private int getLoopLength(ListNode pHead) {
        ListNode pointA = pHead;
        ListNode pointB = pHead;
        //A、B在环中相遇的节点
        ListNode meetPoint = null;
        int length = 0;
        //A每次走两步,B每次走一步,直到A、B相遇
        for (;;) {
            pointA = pointA.next.next;
            pointB = pointB.next;
            if (pointA == pointB) {
                //A、B相遇,此时跳出循环开始计数
                meetPoint = pointA;//记录A、B在环中相遇的节点
                break;
            }
        }
        //计算环的长度
        for (;;) {
            pointA = pointA.next;
            length++;
            if (pointA == meetPoint) {
                break;
            }
        }
        return length;
    }

    //
    public boolean isLoopLinkedList(ListNode pHead) {
        if (pHead == null) {
            return false;
        }
        ListNode pointA = pHead;//指针A
        ListNode pointB = pHead;//指针B
        while (pointA != null) {
            //先判断pointA的下一个是否为null,如果pointA的下一个是null,一次走两步的话就会产生空指针异常
            if (pointA.next != null) {
                //pointA一次走两步,pointB一次走一步
                pointA = pointA.next.next;
                pointB = pointB.next;
                //判断两指针是否相遇
                if (pointA == pointB) {
                    //两指针相遇,成环
                    return true;
                }
            } else {
                //pointA的下一个为null,说明链表不成环
                return false;
            }
        }
        return false;
    }

    public static class ListNode {

        public int value;
        public ListNode next = null;

        public ListNode(int value) {
            this.value = value;
            this.next = next;
        }
    }
}
