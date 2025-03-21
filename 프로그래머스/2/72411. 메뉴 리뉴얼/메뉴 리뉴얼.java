import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int c : course) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combination(chars, new StringBuilder(), 0, c, map);
            }

            for (String key : map.keySet()) {
                int count = map.get(key);
                if (count >= 2) {
                    if (count > max) {
                        max = count;
                    }
                }
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void combination(char[] arr, StringBuilder sb, int idx, int len, Map<String, Integer> map) {
        if (sb.length() == len) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            combination(arr, sb, i + 1, len, map);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}