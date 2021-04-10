package 力扣144二叉树的前序遍历;

import 力扣144二叉树的前序遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> leftPreorder = preorderTraversal(root.left);
        List<Integer> rightPreorder = preorderTraversal(root.right);

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(leftPreorder);
        for (Integer e : rightPreorder) {
            list.add(e);
        }
        return list;
    }
}
