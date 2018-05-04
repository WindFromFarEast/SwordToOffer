package BinaryTree;

import java.util.ArrayList;

//二叉树中和为某个数的路径 路径指的是根结点到一个叶子节点
public class FindPath {

    private ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            //如果当前节点是空,直接返回
            return pathList;
        }
        //将当前节点加入路径
        path.add(root.val);
        target -= root.val;//计算根结点到当前节点的路径和
        if (target == 0 && root.left == null && root.right == null) {
            //如果当前节点是叶子节点,并且根结点到当前节点的路径和为目标值,将这个路径path加入pathList
            pathList.add(new ArrayList<>(path));//注意不能用pathList.add(path),不然在遍历其他路径导致path改变时pathList中之前存放的path也会改变
        }
        //再分别遍历该节点的左子树和右子树,直到各个子树的叶子节点
        FindPath(root.left, target);
        FindPath(root.right, target);
        //访问完当前节点的左子树和右子树后回退到父节点
        //实际上根据递归的性质,执行完这个方法就已经回到了父节点,但是其path还未改变,因此需要我们手动将path中当前节点删除
        //举个例子,访问完5节点的左子树和右子树后,会直接跳到12,但是path中还是10,5  我们需要删除5
        path.remove(path.size() - 1);
        return pathList;
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
