//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 720 👎 0

  
package leetcode.editor.cn;

import leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
          TreeNode node1 = new TreeNode(1);
          TreeNode node2 = new TreeNode(2);
          TreeNode node3 = new TreeNode(3);
          node1.right = node2;
          node2.left = node3;

          List<Integer> res = solution.inorderTraversal(node1);
          System.out.println(res);

      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans = new LinkedList<>();


    /**
     * 中序遍历非递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.addLast(node);
                node = node.left;
            }
            node = stack.pollLast();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
    /**
     * 中序遍历的递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecr(TreeNode root) {
        if (root == null) return ans;
        inorderTraversalRecr(root.left);
        ans.add(root.val);
        inorderTraversalRecr(root.right);
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}