package com.am.study.algorithms.sum;

public class SlidingWindow {

    /**
     * Example 4: Given an integer array nums and an integer k,
     * find the sum of the subarray with the largest sum whose length is k.
     * @param array
     * @param k
     * @return
     */
    public static int maxSum(int array[], int k) {
        if(array == null || array.length < k) {
            return -1;
        }

        int max_sum = 0;
        for(int i = 0; i < k; i++) {
            max_sum += array[i];
        }

        int current_sum = max_sum;
        for(int i = k; i < array.length; i++) {
            current_sum += array[i] - array[i - k];
            max_sum = Math.max(max_sum, current_sum);
        }

        return max_sum;
    }

    /**
     * Example 1: Given an array of positive integers nums and an integer k,
     * find the length of the longest subarray whose sum is less than or equal to k.
     * This is the problem we have been talking about above. We will now formally solve it.
     * @param nums
     * @param k
     * @return
     */
    public static int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0; // curr is the current sum of the window
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(SlidingWindow.maxSum(new int[] {16, 12, 9, 19, 11, 8}, 3));
        System.out.println(SlidingWindow.findLength(new int[] {16, 12, 9, 19, 11, 8}, 11));

        System.out.println(SlidingWindow.maxSum(new int[] {16, 12, 9, 19, 11, 8}, 2));
        System.out.println(SlidingWindow.maxSum(new int[] {16, 12, 9, 19, 11, 8}, 1));
    }
}
