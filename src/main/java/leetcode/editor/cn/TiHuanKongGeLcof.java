package leetcode.editor.cn;

/**
*  @date 2023-08-30 22:40:23
*  @title [剑指 Offer 05] 替换空格
**/
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
       Solution solution = new TiHuanKongGeLcof().new Solution();
        solution.replaceSpace("We are happy.");
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == ' '){
                count++;
            }
        }

        if (count == 0) {
            return s;
        }
        char[] newChars = new char[s.length() + (count * 2)];
        char[] oldChars = s.toCharArray();
        int newIndex = newChars.length - 1;
        int oldIndex = s.length() - 1;

        while (oldIndex >= 0) {
            if(oldChars[oldIndex] == ' '){
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
                newChars[newIndex] = '%';
            }else {
                newChars[newIndex] = oldChars[oldIndex];
            }
            oldIndex--;
            newIndex--;
        }

        return new String(newChars);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}