package BinaryTree;

public class Balance {

    /**
     * 思路
     * 基于后序遍历的递归实现
     * 一、判断当前节点的左子树是否为平衡二叉树
     * 二、判断当前节点的右子树是否为平衡二叉树
     * 三、判断当前节点是否为平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new DepthHolder());
    }

    //判断当前节点的树是否为平衡二叉树,holder是返回参数,表示这个节点树的深度
    private boolean isBalanced(TreeNode root, DepthHolder holder) {
        //空树也是平衡二叉树
        if (root == null) {
            holder.depth = 0;
            return true;
        }
        DepthHolder leftHolder = new DepthHolder();//左子树深度
        DepthHolder rightHolder = new DepthHolder();//右子树深度
        //后序遍历,分别判断左右子树是否为平衡二叉树
        if (isBalanced(root.left, leftHolder) && isBalanced(root.right, rightHolder)) {
            //左子树和右子树都是平衡二叉树
            //再判断当前树是否为平衡二叉树
            int diff = Math.abs(leftHolder.depth - rightHolder.depth);
            if (diff <= 1) {
                //左右子树深度差小于2，当前节点的树是平衡二叉树
                holder.depth = (leftHolder.depth > rightHolder.depth ? leftHolder.depth : rightHolder.depth) + 1;//当前节点树的深度
                return true;
            }
        }
        //不是平衡二叉树
        return false;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private class DepthHolder {
        int depth = 0;
    }
}
