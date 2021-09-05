package dataStructure.hash;
import java.util.HashMap;
/*
* Collision 이 없는 경우 O(1)
* Collision 이 있는 경우 O(n)
* 검색의 좋음
* */

public class javaHashMap {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "eui");
        map.put(2, "jiwon");

        System.out.println(map.get(1));
        System.out.println(map.get(2));

    }

}
