package BinaryTree;

import java.util.Stack;

//两个节点的最低公共祖先
public class LowestCommonNode {

    /**
     * 二叉搜索树的情况下
     * @param root
     * @param nodeOne
     * @param nodeTwo
     * @return
     */
//    public TreeNode findCommonParent(TreeNode root, TreeNode nodeOne, TreeNode nodeTwo) {
//        //
//        TreeNode parent = null;
//        //鲁棒性检查
//        if (root == null || nodeOne == null || nodeTwo == null) {
//            return null;
//        }
//        //
//        int rootVal = root.val;
//        int oneVal = nodeOne.val;
//        int twoVal = nodeTwo.val;
//        if (rootVal < oneVal && rootVal < twoVal) {
//            root = findCommonParent(root.right, nodeOne, nodeTwo);
//        } else if (rootVal > oneVal && rootVal > twoVal) {
//            root = findCommonParent(root.left, nodeOne, nodeTwo);
//        }
//        parent  = root;
//        return parent;
//    }

    /**
     * 普通二叉树的情况下
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode findCommonParent(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode parent = null;
        if (root == null || p == null || q == null) {
            return parent;
        }
        Stack<TreeNode> stackOne = new Stack<>();
        Stack<TreeNode> stackTwo = new Stack<>();
        getPath(root, p, stackOne);
        getPath(root, p, stackTwo);
        while ((!stackOne.isEmpty()) && (!stackTwo.isEmpty())) {
            TreeNode one = stackOne.pop();
            TreeNode two = stackTwo.pop();
            if (one.val == two.val) {
                parent = one;
                break;
            }
        }
        return parent;
    }

    private void getPath(TreeNode root, TreeNode p, Stack stack) {
        TreeNode node = root;
        if (node == null) {
            return;
        }
        if (node.val == p.val) {
            stack.push(p);
        } else if (node.val > p.val) {
            stack.push(node.left);
            getPath(node.left, p, stack);
        } else {
            stack.push(node.right);
            getPath(node.right, p, stack);
        }
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
