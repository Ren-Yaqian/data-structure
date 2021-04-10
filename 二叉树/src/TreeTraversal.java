public class TreeTraversal {
    // 前序遍历 preorder traversal
    // 参数中是树，不是结点
    public static void preorder(TreeNode root) {
        if (root == null) {
            // 根结点不存在，说明是空树
            return;
        }

        // 遍历到任意一个结点时，只需要打印根的 val
        System.out.printf("%c ", root.val);

        preorder(root.left);    // root.left 代表是一整棵左子树
        preorder(root.right);
    }
    // 中序遍历 inorder traversal
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.printf("%c ", root.val);
        inorder(root.right);
    }
    // 后序遍历 postorder traversal
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.printf("%c ", root.val);
    }

    public static void allAdd1(TreeNode root) {
        if (root != null) {
            root.val += 1;
            allAdd1(root.left);
            allAdd1(root.right);
        }
    }

    public static int count;
    public static void count1(TreeNode root) {
        if (root != null) {
            count++;
            count1(root.left);
            count1(root.right);
        }
    }

    public static int count2(TreeNode root) {
        if (root != null) {
            int leftCount = count2(root.left);
            int rightCount = count2(root.right);

            return 1 + leftCount + rightCount;
        }

        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        count = 0;
        count1(root);
        System.out.println(count);
        count = 0;
        count1(root);
        System.out.println(count);

        System.out.println(count2(root));
        System.out.println(count2(root));
        System.out.println(count2(root));
//        allAdd1(root);
//
//        System.out.print("前序遍历:");
//        preorder(root);
//        System.out.println();
//
//
//        System.out.print("中序遍历:");
//        inorder(root);
//        System.out.println();
//
//
//        System.out.print("后序遍历:");
//        postorder(root);
//        System.out.println();
    }
}
