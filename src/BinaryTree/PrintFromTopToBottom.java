package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上往下打印二叉树,实质上是层序遍历
public class PrintFromTopToBottom {

    //从上往下打印二叉树
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //存储打印结果的表
        ArrayList<Integer> list = new ArrayList<>();
        //鲁棒性检查
        if (root == null) {
            return list;
        }
        //使用队列实现层序遍历,先进先出,LinkedList本身实现了Queue接口
        Queue<TreeNode> queue = new LinkedList<>();
        //首先将根节点加入队列
        queue.offer(root);
        //只要队列不为空就一直从队列中取出节点
        while (!queue.isEmpty()) {
            //取出当前节点
            TreeNode node = queue.poll();
            //取后要将取出的节点的孩子节点先放入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            //将当前节点取出
            list.add(node.val);
        }
        return list;
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
