class Solution {
    public int maxProfit(int[] nums) {
        int n =nums.length;
        int maxNum = nums[n-1];
        int ans = 0;
        for(int i =n-1;i>=0;i--){
            maxNum = Math.max(nums[i],maxNum);
            ans=Math.max(maxNum-nums[i],ans);
        }
        return ans;
    }
}