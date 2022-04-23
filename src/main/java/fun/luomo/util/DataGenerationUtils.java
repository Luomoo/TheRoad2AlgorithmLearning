package fun.luomo.util;

/**
 * @author gluomo
 */
public class DataGenerationUtils {
    /**
     * 单个int数组生成方法
     *
     * @param maxSize  最大长度
     * @param maxValue 最大数值[-maxValue,maxValue]
     * @return int数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

}
