import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 양쪽의 {{ }} 제거
        // 예: "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        //  -> "2},{2,1},{2,1,3},{2,1,3,4"
        String inner = s.substring(2, s.length() - 2);

        // "},{" 기준으로 각 집합 문자열 분리
        String[] parts = inner.split("\\},\\{");

        // 각 집합을 int 배열로 변환해서 리스트에 담기
        List<int[]> list = new ArrayList<>();
        for (String part : parts) {
            String[] nums = part.split(",");
            int[] arr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            list.add(arr);
        }

        // 집합 길이 기준 오름차순 정렬
        // 예: {2}, {2,1}, {2,1,3}, {2,1,3,4}
        list.sort(Comparator.comparingInt(a -> a.length));

        List<Integer> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        // 길이가 작은 집합부터 보면서
        // 아직 안 나온 숫자를 순서대로 추가
        for (int[] arr : list) {
            for (int x : arr) {
                if (!used.contains(x)) {
                    used.add(x);
                    result.add(x);
                }
            }
        }

        // List<Integer> -> int[]
        return result.stream().mapToInt(i -> i).toArray();
    }
}