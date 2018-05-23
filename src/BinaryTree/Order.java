package BinaryTree;

import java.util.Stack;

//遍历二叉树
public class Order {

    /**
     * 先序遍历二叉树（非递归）
     * 思路：
     * 将每个节点压入栈，从栈中取出节点后，再将该节点的右孩子和左孩子压入栈
     */
    //先序遍历二叉树（非递归）
    public void preOrderNR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        //将根结点压入栈
        stack.push(root);
        //开始遍历
        while (!stack.isEmpty()) {
            //首先取出栈顶节点
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            System.out.print(node.val + ",");
            //将该节点的右孩子和左孩子分别压入栈(顺序不能错)
            stack.push(node.right);
            stack.push(node.left);
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(18);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        Order order = new Order();
        order.preOrderNR(root);
    }
}
