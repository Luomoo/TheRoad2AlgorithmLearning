package leetcode.editor.cn;

import fun.luomo.util.PrintUtil;

/**
 * @date 2023-08-24 21:53:24
 * @title [59] 螺旋矩阵 II
 **/
public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] ints = solution.generateMatrix(3);
        PrintUtil.printMatrix(ints);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int s = 0, x = n - 1, z = 0, y = n - 1;
            int[][] res = new int[n][n];
            int cur = 1;
            int num = n * n;
            while (cur <= num) {
                for (int i = z; i <= y; i++) {
                    res[s][i] = cur++;
                }
                s++;
                for (int i = s; i <= x; i++) {
                    res[i][y] = cur++;
                }
                y--;
                for (int i = y; i >= z; i--) {
                    res[x][i] = cur++;
                }
                x--;
                for (int i = x; i >= s; i--) {
                    res[i][z] = cur++;
                }
                z++;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}