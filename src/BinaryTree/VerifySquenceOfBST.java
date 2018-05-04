package BinaryTree;

//二叉搜索树的后序遍历序列
public class VerifySquenceOfBST {

    /**
     * 思路
     * 1、找到根结点
     * 2、找到左子树边界索引（因为从左开始遍历,因此左子树必定全部小于根结点,但是右子树不一样），同时也找到了右子树边界索引，
     * 但还需要判断右子树元素是否全大于根结点，若右子树中有元素小于根结点，说明以该根结点形成的树不是二叉搜索树
     * 3、判断左子树是否是二叉搜索树
     * 4、判断右子树是否是二叉搜索树
     */
    //判断一个序列是否是二叉搜索树的后序遍历序列
    public static boolean VerifySquenceOfBST(int[] sequence) {
        //鲁棒性检查
        if (sequence.length == 0) {
            return false;
        }
        //首先找到根结点
        int root = sequence[sequence.length - 1];
        //找到这个根结点的左子树边界索引(同时也找到了右子树边界索引),二叉搜索树中左子树的节点都小于根结点
        int leftIndex = 0;
        for (; leftIndex < sequence.length - 1; leftIndex++) {//注意这里的sequence.length - 1，减一是因为最后一个是根结点
            if (sequence[leftIndex] > root) {
                //此时的leftIndex为第一个大于根结点的元素索引,即右子树序列开始的元素
                break;
            }
        }
        //二叉搜索树中右子树的节点都大于根结点,若存在一个节点大于根结点则说明以该根结点形成的树不是二叉搜索树
        int rightIndex = leftIndex;
        for (; rightIndex < sequence.length - 1; rightIndex++) {
            if (sequence[rightIndex] < root) {
                //右子树中有小于根结点的值,因此该树不是二叉搜索树
                return false;
            }
        }
        //完成上述步骤说明以该根结点的左子树都小于它,右子树都大于它,因此以该根结点形成的二叉树是二叉搜索树
        //但是还无法判断其左、右子树是否也为二叉搜索树

        //判断左子树是否为二叉搜索树
        boolean left = true;//默认值必须为true,因为如果没有左子树,那么表示左子树是二叉搜索树
        if (leftIndex > 0) {
            //leftIndex大于0说明存在左子树
            int[] leftSequence = new int[leftIndex];//左子树序列
            for (int i = 0; i < leftIndex; i++) {
                leftSequence[i] = sequence[i];
            }
            left = VerifySquenceOfBST(leftSequence);
        }

        //判断右子树是否为二叉搜索树
        boolean right = true;//默认值必须为true,因为如果没有右子树,那么表示右子树是二叉搜索树
        if (leftIndex < sequence.length - 1) {
            //存在右子树
            int[] rightSequence = new int[sequence.length - 1 - leftIndex];//右子树序列
            for (int i = leftIndex; i < sequence.length - 1; i++) {
                rightSequence[i - leftIndex] = sequence[i];
            }
            right = VerifySquenceOfBST(rightSequence);
        }

        return (left && right);
    }

    public static void main(String[] args) {
        int[] sequence = {4,8,6,12,16,14,10};
        VerifySquenceOfBST(sequence);
    }

}
