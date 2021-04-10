package niuke二叉树遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char rootValue) {
            this.val = rootValue;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    private static int index;
    private static TreeNode buildTree3(char[] preorder) {
        if(index>=preorder.length) {
            return null;
        }

        char rootValue=preorder[index++];
        if(rootValue=='#'){
            return null;
        }
        TreeNode root=new TreeNode(rootValue);
        root.left=buildTree3(preorder);
        root.right=buildTree3(preorder);

        return root;
    }

    private static TreeNode buildTree2(List<Character> preorder) {
        if (preorder.isEmpty()) {
            return null;
        }

        char rootValue = preorder.remove(0);
        if (rootValue == '#') {
            return null;
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree2(preorder);
        root.right = buildTree2(preorder);

        return root;
    }

    static class ReturnType {
        TreeNode builtRoot;
        int used;
    }

    private static ReturnType buildTree(List<Character> preorder) {
        if (preorder.isEmpty()) {
            ReturnType rt = new ReturnType();
            rt.builtRoot = null;
            rt.used = 0;
            return rt;
        }

        // 1. 获取根的值
        char rootValue = preorder.get(0);
        if (rootValue == '#') {
            ReturnType rt = new ReturnType();
            rt.builtRoot = null;
            rt.used = 1;
            return rt;

        }
        TreeNode root = new TreeNode(rootValue);

        // 2. 构建左子树
        List<Character> leftSubTreePreorder = preorder.subList(1, preorder.size());
        ReturnType leftReturn = buildTree(leftSubTreePreorder);
        root.left = leftReturn.builtRoot;

        // 3. 构建右子树
        List<Character> rightSubTreePreorder = preorder.subList(1 + leftReturn.used, preorder.size());
        ReturnType rightReturn = buildTree(rightSubTreePreorder);
        root.right = rightReturn.builtRoot;

        // 4. 返回我们的两个信息
        ReturnType rt = new ReturnType();
        rt.builtRoot = root;
        rt.used = 1 + leftReturn.used + rightReturn.used;
        return rt;
    }

    public static void main(String[] args) {
        String s = "ABC##DE#G##F###";
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char ch : chars) {
            list.add(ch);
        }

        ReturnType returnType = buildTree(list);
        System.out.println(returnType.builtRoot);
        System.out.println(returnType.used);
    }
}
