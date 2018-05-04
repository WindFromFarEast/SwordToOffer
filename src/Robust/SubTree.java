package Robust;

public class SubTree {

    //判断树root2是否为root1的子树
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        //首先判断当前遍历到的root1中的节点是否和root2的根结点相同,若相同则再接着判断左右节点是否也相同;若不相同则继续在root1找相同的根结点
        //找到相同的根结点后,再判断root1中以当前根节点的树的结构是否和root2相同
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                //根结点相同,判断root1中以当前根节点的树的结构是否和root2相同
                result = doesRoot1HaveRoot2(root1, root2);
            }
            if (!result) {
                //根结点不相同,继续在root1的左子树中寻找相同的根结点
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                //根结点不相同,继续在root1的右子树中寻找相同的根结点
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    //root1和root2根节点值相同,判断root1是否包含root2
    private boolean doesRoot1HaveRoot2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesRoot1HaveRoot2(root1.left, root2.left) && doesRoot1HaveRoot2(root1.right, root2.right);
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
