package BinaryTree;

//找到中序遍历中的下一个节点
public class NextNode {

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //如果该节点有右子树,那么右子树的最左节点就是下一个节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //没有右子树,那么就从该节点开始,往其父节点遍历,找到第一个左孩子节点(包括该节点)的父节点
        while (pNode.next != null) {
            //判断当前节点是否为左孩子节点
            if (pNode.next.left == pNode) {
                //当前节点为左孩子节点,那么其父节点就是下一个节点
                return pNode.next;
            }
            //当前节点不是左孩子节点,继续向其父节点遍历
            pNode = pNode.next;
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
