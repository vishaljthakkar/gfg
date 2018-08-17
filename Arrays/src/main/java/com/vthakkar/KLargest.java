package com.vthakkar;

import java.util.Arrays;

public class KLargest {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
