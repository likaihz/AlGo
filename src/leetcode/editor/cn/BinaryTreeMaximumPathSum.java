//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3]
//
//       1
//      / \
//     2   3
//
//输出：6
// 
//
// 示例 2： 
//
// 输入：[-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出：42 
// Related Topics 树 深度优先搜索 
// 👍 711 👎 0

  
package leetcode.editor.cn;

import leetcode.model.TreeNode;


public class BinaryTreeMaximumPathSum{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeMaximumPathSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        recr(root);
        return max;
    }

    private int recr(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) {
            max = Math.max(max, node.val);
            return node.val;
        }

        int leftMax = recr(node.left);
        int rightMax = recr(node.right);
        int sum = node.val;
        if(leftMax > 0) sum += leftMax;
        if(rightMax > 0) sum += rightMax;
        max = Math.max(max, sum);
        int oneMax = Math.max(leftMax, rightMax);
        if(oneMax > 0) return node.val + oneMax;
        else return node.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}