import java.util.ArrayList;
import java.util.Stack;

//Given a binary tree, return the postorder traversal of its nodes' values.
public class PostOrderBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public class Solution {
        public ArrayList<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            stack.push(root);
            while(!stack.empty() && root != null){
                TreeNode tmp = stack.peek();
                if(tmp.left != null){
                    stack.push(tmp.left);
                    tmp.left = null;
                    continue;
                }
                else if(tmp.right != null){
                    stack.push(tmp.right);
                    tmp.right = null;
                    continue;
                }
                arrayList.add(tmp.val);
                stack.pop();
            }
            return arrayList;
        }
    }
}
