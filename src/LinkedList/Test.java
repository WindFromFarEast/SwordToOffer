package LinkedList;

public class Test {
    public static void main(String[] args) {
        EntryNodeOfLoop.ListNode node1 = new EntryNodeOfLoop.ListNode(2);
        EntryNodeOfLoop.ListNode node2 = new EntryNodeOfLoop.ListNode(2);
        EntryNodeOfLoop.ListNode node3 = new EntryNodeOfLoop.ListNode(3);
        EntryNodeOfLoop.ListNode node4 = new EntryNodeOfLoop.ListNode(4);
        EntryNodeOfLoop.ListNode node5 = new EntryNodeOfLoop.ListNode(5);
        EntryNodeOfLoop.ListNode node6 = new EntryNodeOfLoop.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
        entryNodeOfLoop.EntryNodeOfLoop(node1);
    }
}
