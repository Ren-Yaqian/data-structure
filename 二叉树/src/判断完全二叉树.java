import java.util.LinkedList;
import java.util.Queue;

public class 判断完全二叉树 {
    public static boolean check(TreeNode head) {
        boolean leaf = false; // 是否开启了状态
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(head);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode l = cur.lchild;
            TreeNode r = cur.rchild;
            if ((leaf && (l != null && r != null)) || (l == null && r != null))
                return false;
            if (l != null)
                q.add(l);
            if (r != null)
                q.add(r);
            else
                leaf = true;
        }
        return true;
    }
}
