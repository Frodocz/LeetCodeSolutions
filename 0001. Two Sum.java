/*
 * Difficulty: Easy
 * Tags: Array, Hash Table
 * Favorite: No
 * Details: Runtime: 1ms, faster than 99.95% of Java online submissions for Two Sum.
            Memory Usage: 39.7 MB, less than 55.95% of Java online submissions for Two Sum.
 */

class Solution {
    // HashMap --> Time: O(n) Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{hm.get(target - nums[i]), i};
            }
            hm.put(nums[i], i);
        }
        return new int[2];
    }
}