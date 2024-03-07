package hash;

import java.util.*;

/**
 * fly  2024/3/3
 */
public class OD2831 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("A",new ArrayList<>());
        map.put("B",new ArrayList<>());
        map.put("C",new ArrayList<>());
        while (s.hasNext()){
            String[] tars = s.nextLine().split(" ");
            List<String> l = map.get(tars[1]);
            l.add(tars[0]);
            map.put(tars[1],l);
        }
        List<String> result = null;
        if(map.get("A").size() == 0){
            if(map.get("B").size() != 0 && map.get("C").size() != 0){
                result = map.get("B");
            }
        }else {
            if(map.get("B").size() == 0){
                if(map.get("C").size() != 0){
                    result = map.get("C");
                }
            }else {
                if(map.get("C").size() == 0) {
                    result = map.get("A");
                }
            }
        }
        if(result == null){
            System.out.println("NULL");
            return;
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String str : result){
            System.out.println(str);
        }
    }
}
