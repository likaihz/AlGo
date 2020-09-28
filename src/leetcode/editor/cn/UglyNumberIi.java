//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 390 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class UglyNumberIi{
      public static void main(String[] args) {
           Solution solution = new UglyNumberIi().new Solution();
          System.out.println(solution.nthUglyNumber(12));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        Map<Integer, Integer> pMap = new HashMap<>();
        pMap.put(2, 0);
        pMap.put(3, 0);
        pMap.put(5, 0);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int p = 1; p < n; p++) {
            int maxP = 2;
            for (int tmp : pMap.keySet()) {
                if (dp[pMap.get(maxP)] * maxP > dp[pMap.get(tmp)] * tmp) {
                    maxP = tmp;
                }
            }
            dp[p] = dp[pMap.get(maxP)] * maxP;
            for (int tmp : pMap.keySet()) {
                if (dp[p] == dp[pMap.get(tmp)] * tmp) {
                    pMap.put(tmp, pMap.get(tmp) + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}