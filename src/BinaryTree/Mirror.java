package BinaryTree;

//二叉树的镜像
public class Mirror {

    //将二叉树root镜像
    public void Mirror(TreeNode root) {
        //鲁棒性检查
        if (root == null) {
            return;
        }
        //遍历到叶子节点为递归终止条件
        if (root.left == null && root.right == null) {
            return;
        }
        //交换当前节点两个孩子节点的位置,能到这一步说明当前节点不是叶子节点,至少有一个孩子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //继续向下递归
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
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
