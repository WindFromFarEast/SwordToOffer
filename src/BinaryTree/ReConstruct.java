package BinaryTree;

//根据先序遍历和中序遍历重建二叉树
public class ReConstruct {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 整体思路就是先在先序遍历中找到根结点,再在中序遍历中找到这个根结点的位置,该位置左边即为根结点的左子树,右边即为根结点右子树
     * 再对其左、右子树做这样的递归操作。
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    //递归方法,根据前序遍历数组in和中序遍历数组pre,得到指定范围内的根结点
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //获取当前指定范围内(pre[startPre]~pre[endPre]和in[startIn]~in[endIn])的根结点
        TreeNode root = new TreeNode(pre[startPre]);
        //首先在中序遍历数组中找到根结点位置,根结点左边的就是其左子树,右边的就是其右子树
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                //找到了中序遍历数组中根结点的位置i, i-startIn可以理解为左子树的长度
                //递归寻找根结点的左子树和右子树
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;//跳出循环
            }
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
