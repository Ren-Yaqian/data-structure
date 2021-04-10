package 层序遍历;



import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void levelorder(TreeNode root) {
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            System.out.println(node.val);

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
}
