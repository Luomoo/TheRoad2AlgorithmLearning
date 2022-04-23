package fun.luomo.algorithm;

import fun.luomo.util.DataGenerationUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author gluomo
 * @describe TopK问题
 */
public class TopKTimesRealTime {
    @Test
    public void fun1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(DataGenerationUtils.generateRandomArray(10, 100)));
        }
    }

    private void optimizationMethod1() {

    }

    private void brainlessMethod() {

    }
}
