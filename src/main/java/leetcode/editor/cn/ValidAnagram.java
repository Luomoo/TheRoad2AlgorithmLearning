package leetcode.editor.cn;

/**
 * @date 2023-08-28 21:57:34
 * @title [242] 有效的字母异位词
 **/
public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        // System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] arr = new int[26];

            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a'] += 1;
            }

            for (int i = 0; i < t.length(); i++) {
                arr[t.charAt(i) - 'a'] -= 1;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    return false;
                }

            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}