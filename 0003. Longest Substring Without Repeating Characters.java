/*
 * Difficulty: Medium
 * Tags: Hash Table, Two Pointers, String, Sliding Window
 * Favorite: Yes
 * Details: Runtime: 5 ms, faster than 88.59% of Java online submissions for Longest Substring Without Repeating Characters.
            Memory Usage: 39.7 MB, less than 67.01% of Java online submissions for Longest Substring Without Repeating Characters.
 */

class Solution {
    // Sliding Window using HashSet --> Time: O(2n) = O(n) Space: O(min(m,n))
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // Sliding Window using HashMap --> Time: O(n) Space: O(min(m,n))
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}