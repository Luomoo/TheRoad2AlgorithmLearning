package fun.luomo.algorithm.tree;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author gluomo
 * @describe 打印文件树
 */
public class GetFolderTree {

    @Test
    public void fun1() {
        String[] arr = {"a\\b\\c", "a\\b\\cd"};
        Node node = generateFolderTree(arr);
        printProcess(node, 0);
    }


    public void printProcess(Node node, int level) {
        if (level != 0) {
            System.out.println(get2Space(level) + node.path);
        }
        for (Node next : node.next.values()) {
            printProcess(next, level + 1);
        }
    }

    private String get2Space(int level) {
        StringBuilder res = new StringBuilder();

        for (int i = 1; i < level; i++) {
            res.append("\t");
        }
        return res.toString();
    }

    /**
     * @param folderPaths 路径
     * @return Node节点
     * @describe 生成前缀树
     */
    public Node generateFolderTree(String[] folderPaths) {
        Node head = new Node("");
        for (String folderPath : folderPaths) {
            String[] path = folderPath.split("\\\\");
            Node cur = head;
            for (int i = 0; i < path.length; i++) {
                if (!cur.next.containsKey(path[i])) {
                    cur.next.put(path[i], new Node(path[i]));
                }
                cur = cur.next.get(path[i]);
            }
        }

        return head;
    }

    class Node {
        String path;
        Map<String, Node> next = new TreeMap<>();


        public Node(String path) {
            this.path = path;
        }
    }
}
