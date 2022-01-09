package com.wf.workfuture.algorithmPractise.jianzhiOffer;

/**
 * Created by wangfeng 17:06 2020/11/1
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 **/
public class Question_42 {

    /**
     * 找每一个序列的和最后选最大的
     * @param nums
     * @return
     */
    public static Integer maxSubArray2(int[] nums){
        int tempCount;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempCount = 0;
            for (int j = i ; j < nums.length; j++) {
                tempCount += nums[j];
                if(tempCount > maxCount) {
                    maxCount = tempCount;
                }
            }
        }
        return maxCount;
    }

    /**
     * 累加数组和，最大子序列和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
            System.out.print(sum + " ");
        }
        System.out.println();
        return max;
    }

    public int maxSubArray0(int[] nums) {
        int sum = 0, max = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * max(dp[i]) = max(dp[i-1] + array[i], array[i])
     *
     * @param nums
     * @return
     */

    public static Integer maxSubArrayDp(int[] nums){
        //1、临时最大值
        int sum = nums[0];
        //2、比较滞后的最大值
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //max(dp[i]) = max(dp[i-1] + array[i], array[i])
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * max(dp[i]) = max(dp[i-1] + array[i], array[i])
     *
     * @param nums
     * @return
     */
    public static Integer maxSubArrayDp1(int[] nums){
        //当前节点为序列尾节点时，序列的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        //2、比较滞后的最大值
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //max(dp[i]) = max(dp[i-1] + array[i], array[i])
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        for (int d : dp) {
            System.out.print(d + " ");
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
//        System.out.println(maxSubArrayDp(nums));
        System.out.println(maxSubArrayDp1(nums));
    }

}
