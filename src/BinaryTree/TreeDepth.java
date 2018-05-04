package BinaryTree;

import java.util.ArrayList;
import java.util.Comparator;

//求二叉树的深度 实际上和 “二叉树中和为某个数的路径”是一样的
public class TreeDepth {

    //所有路径的深度,最终取出最大即可
    private ArrayList<Integer> depthList = new ArrayList<>();
    //当前访问路径的深度
    private int depth = 0;

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //当前节点存在,深度加一
        depth++;
        if (root.left == null && root.right == null) {
            //当前节点为叶子节点,将这个路径的深度加入list
            depthList.add(depth);
        }
        //继续遍历当前节点的左子树和右子树
        TreeDepth(root.left);
        TreeDepth(root.right);
        //回到父节点时将深度减一
        depth--;
        //对所有路径的深度进行降序排序
        depthList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //返回路径深度的最大值
        return depthList.get(0);
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
