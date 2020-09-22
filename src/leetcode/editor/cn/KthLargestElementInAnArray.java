//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 709 👎 0

  
package leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray{
      public static void main(String[] args) {
           Solution solution = new KthLargestElementInAnArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, k);
    }

    private int sort(int[] nums, int lo, int hi, int k) {
        if(lo >= hi) return nums[k - 1];
        int j = partition(nums, lo, hi);
        if(j == k-1) {
            return nums[j];
        } else if (j < k-1) {
            return sort(nums, j + 1, hi, k);
        } else {
            return sort(nums, lo, j - 1, k);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        // 平台的测试用例中有极端情况，这里随机打乱一下可以提高效率
        int pr = random.nextInt(hi - lo) + lo;
        swap(nums, lo, pr);
        while (i < j) {
            while (nums[++i] >= nums[lo]) if(i == hi) break;
            while (nums[--j] <= nums[lo]) if(j == lo) break;

            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}