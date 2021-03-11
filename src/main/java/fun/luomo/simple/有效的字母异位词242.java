package fun.luomo.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author luomo
 * @date 2020/11/22 23:03
 */
public class 有效的字母异位词242 {
    @Test
    public void fun1() {

    }

    public boolean isAnagram1(String s, String t) {
        char[] sC = s.toCharArray();
        char[] sT = t.toCharArray();
        Arrays.sort(sC);
        Arrays.sort(sT);
        return String.valueOf(sC).equals(String.valueOf(sT));
    }
    public boolean isAnagram2(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            Integer count =  map.get(t.charAt(i));
            if(count==null){
                return false;
            }else if(count > 1){
                map.put(t.charAt(i),count-1);
            }else{
                map.remove(t.charAt(i));
            }
        }
        return map.isEmpty();
    }

}
