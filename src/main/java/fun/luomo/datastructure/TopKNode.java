package fun.luomo.datastructure;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gluomo
 * @describe TopK堆节点
 */
@Data
@AllArgsConstructor
public class TopKNode {

    private String str;

    /**
     * 词频
     */
    private int times;
}
