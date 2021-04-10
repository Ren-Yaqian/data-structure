package 力扣144二叉树的前序遍历;

import 力扣144二叉树的前序遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<Integer> list = new ArrayList<>();

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        //System.out.println(root);
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        list.clear();
        preorder(root);
        return list;
    }
}
