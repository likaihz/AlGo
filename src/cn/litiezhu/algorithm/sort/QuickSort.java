package cn.litiezhu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序的实现
 * @author Li Kai
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] nums = new int[]{3,4,1,3,6,9,8};
        sort.qsort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void qsort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if(lo >= hi) return;
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (i < j) {
            while (nums[++i] <= nums[lo]) if(i == hi) break;
            while (nums[--j] > nums[lo]) if(j == lo) break;

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;
        return j;
    }

}
