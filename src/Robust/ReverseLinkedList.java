package Robust;

//反转链表
public class ReverseLinkedList {

    //传入链表的头指针,反转该链表
    public ListNode reverseList(ListNode head) {
        //需要使用到三个指针,一个指向当前节点的前一个节点,一个指向当前节点,一个指向反转后链表的头节点
        ListNode pointReversedHead = null;//反转后链表的头结点
        ListNode pointNode = head;//当前节点
        ListNode pointPrev = null;//当前节点的前一个节点
        while (pointNode != null) {
            //为了防止链表断裂需要将当前节点的下一个节点保存起来
            ListNode nextNode = pointNode.next;
            //若下一个节点是空节点,说明当前节点就是反转后的头结点
            if (nextNode == null) {
                pointReversedHead = pointNode;
            }
            //让当前节点指针指向前一个节点,此处会丢失下一个节点的指针,因此在前面需要保存下一个节点
            pointNode.next = pointPrev;
            //指针后移
            pointPrev = pointNode;
            pointNode = nextNode;
        }
        return pointReversedHead;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
