import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String paragraph = "Trong khu vườn nhỏ có một cây cam Cây cam này rất đặc biệt vì cây cam luôn ra rất nhiều trái " +
                "Mỗi sáng bà Tư ra thăm cây cam tưới nước cho cây cam và nhặt lá rụng quanh cây cam Hàng xóm ai cũng thích cây cam của bà Tư ";
        String lover = paragraph.toLowerCase();
        String[] arr = lover.split(" ");

        Map<String,Integer> map = new HashMap<>();
        for (String s: arr) {
            addMap(s.trim(), map);
        }

        System.out.println(map);
     }

     public static void addMap(String s, Map<String, Integer> map) {
        if (map.containsKey(s)) {
            for (Map.Entry<String, Integer> e: map.entrySet()) {
                if (e.getKey().equals(s)) {
                    e.setValue(e.getValue() + 1);
                }
            }
        } else {
            map.put(s, 1);
        }
     }
}