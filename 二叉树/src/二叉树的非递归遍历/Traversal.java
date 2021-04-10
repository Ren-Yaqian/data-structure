package 二叉树的非递归遍历;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    public static void preorder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.pop();

            cur = pop.right;
        }
    }

    public static void inorder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.pop();
            System.out.println(pop.val);

            cur = pop.right;
        }
    }



    public static void postorder(TreeNode root) {
        TreeNode cur = root;
        TreeNode last = null;   // 记录上次刚刚后序遍历过的结点
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.peek();
            if (pop.right == null) {
                stack.pop();
                System.out.println(pop.val);
                last = pop;
            } else if (pop.right == last) {
                stack.pop();
                System.out.println(pop.val);
                last = pop;
            } else {
                cur = pop.right;
            }
        }
    }

    //层序遍历
    public static void levelorder(TreeNode root) {
        if(root==null){
            return;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> levelQueue=new LinkedList<>();//层数
        queue.add(root);
        levelQueue.add(0);

        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            int level=levelQueue.remove();
            System.out.println(level + ':' + node.val);
//            System.out.println(node.val);

            if(node.left!=null){
                queue.add(node.left);
                levelQueue.add(level+1);
            }
            if(node.right!=null){
                queue.add(node.right);
                levelQueue.add(level+1);
            }
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftSize = i;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 8, 3, 6, 7};
        int[] inorder = {4, 2, 5, 8, 1, 6, 3, 7};
        TreeNode root = buildTree(preorder, inorder);

        levelorder(root);
//        postorder(root);
    }
}
