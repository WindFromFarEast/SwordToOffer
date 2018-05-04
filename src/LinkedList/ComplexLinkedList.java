package LinkedList;

//复杂链表的复制
public class ComplexLinkedList {

    /**
     * 思路：
     * 整个复制的过程分成三步：
     * 一、遍历整个链表，根据原始链表的每个节点N创建对应的复制节点N',将N'连接在N的后面
     * 二、设置复制出来的节点的random,假设原始链表上的N的random指向节点S,那么其复制出来的N'是N的next,同理S'是S的next
     * 三、将奇数位置的节点连接起来就是原始链表,偶数位置的节点连接起来就是复制链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        //鲁棒性检查
        if (pHead == null) {
            return null;
        }
        //根据原始链表的每个节点N创建对应的复制节点N',将N'连接在N的后面
        cloneNodes(pHead);
        //设置复制出来的节点的random,假设原始链表上的N的random指向节点S,那么其复制出来的N'是N的next,同理S'是S的next
        connectRandomNodes(pHead);
        //将奇数位置的节点连接起来就是原始链表,偶数位置的节点连接起来就是复制链表
        return reconnectNodes(pHead);
    }

    //根据原始链表的每个节点N创建对应的复制节点N',将N'连接在N的后面
    private void cloneNodes(RandomListNode head) {
        //头节点的备份
        RandomListNode node = head;
        while (node != null) {
            //复制的节点
            RandomListNode copiedNode = new RandomListNode(node.label);
            //将复制的节点连接在原始节点的后面
            copiedNode.next = node.next;
            copiedNode.random = null;
            node.next = copiedNode;
            //向后走两步才到原始链表中的下一个节点,只走一步的话到达的是复制节点
            node = node.next.next;
        }
    }

    //设置复制出来的节点的random,假设原始链表上的N的random指向节点S,那么其复制出来的N'是N的next,同理S'是S的next
    private void connectRandomNodes(RandomListNode head) {
        RandomListNode node = head;
        while (node != null) {
            //原始链表上的N的random指向节点S,那么其复制出来的N'是N的next,同理S'是S的next
            node.next.random = node.random.next;
            //同理,向后走两步
            node = node.next.next;
        }
    }

    //将奇数位置的节点连接起来就是原始链表,偶数位置的节点连接起来就是复制链表
    private RandomListNode reconnectNodes(RandomListNode head) {
        //原始链表节点
        RandomListNode node = head;
        //复制链表节点
        RandomListNode clonedNode = head.next;
        //复制链表头节点
        RandomListNode clonedHead = head.next;
        //
        while (node != null) {
            node.next = clonedNode.next;
            node = node.next;
            clonedNode.next = node.next;
        }
        return clonedHead;
    }

    //复杂链表类
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
