public class maxSubaarray {
    public static void main(String[] args) {
        // Example usage:
        int[] nums = { -2, 3, 4, -1, -3};
        System.out.println(maxSub(nums)); // Output: 6
    }

    public static int maxSub(int[] nums) {
        int max = nums[0];
        int curMax = 0;
        int maxNumber = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curMax = curMax + nums[i];
            if (curMax < 0) {
                maxNumber = Math.max(maxNumber, curMax);
                curMax = 0;
            } else {
                max = Math.max(curMax, max);
            }
        }
        return (max < 0) ? maxNumber : max;
    }
}