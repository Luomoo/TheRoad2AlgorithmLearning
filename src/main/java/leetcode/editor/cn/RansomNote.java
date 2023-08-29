package leetcode.editor.cn;

/**
 * @date 2023-08-29 16:21:41
 * @title [383] 赎金信
 **/
public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        System.out.println(solution.canConstruct("a", "b"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            int[] arr = new int[26];

            for (int i = 0; i < magazine.length(); i++) {
                char c = magazine.charAt(i);
                arr[c - 'a'] += 1;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                char c = ransomNote.charAt(i);
                arr[c - 'a'] -= 1;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}