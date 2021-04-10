package 力扣106从中序与后序遍历序列构造二叉树;

import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int len=postorder.length;
        int rootValue = postorder[len-1];
        TreeNode root = new TreeNode(rootValue);

        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftSize = i;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftSize);
        root.left = buildTree(leftInorder,leftPostorder);

        int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftSize, postorder.length-1);
        root.right = buildTree(rightInorder,rightPostorder);

        return root;
    }
}
