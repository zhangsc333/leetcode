import java.util.ArrayList;
import java.util.Stack;

//Given a binary tree, return the preorder traversal of its nodes' values.
public class PreOrderBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public class Solution {
        public ArrayList<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty() && root != null){
                TreeNode temp = stack.pop();
                if(temp.right != null){
                    stack.push(temp.right);
                }
                if(temp.left != null){
                    stack.push(temp.left);
                }
                list.add(temp.val);
            }
            return list;
        }
    }
}
