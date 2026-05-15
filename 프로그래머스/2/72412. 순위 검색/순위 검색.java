import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1. info로 가능한 모든 조건 조합 만들기
        for (String in : info) {
            String[] arr = in.split(" ");

            String[] condition = {
                arr[0], arr[1], arr[2], arr[3]
            };

            int score = Integer.parseInt(arr[4]);

            makeKey(condition, score, 0, "");
        }

        // 2. 각 key별 점수 리스트 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // 3. query 처리
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");

            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
            } else {
                List<Integer> scores = map.get(key);
                answer[i] = scores.size() - lowerBound(scores, score);
            }
        }

        return answer;
    }

    // 조건 조합 만들기
    void makeKey(String[] condition, int score, int depth, String key) {
        if (depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        // 실제 조건 사용
        makeKey(condition, score, depth + 1, key + condition[depth]);

        // '-' 조건 사용
        makeKey(condition, score, depth + 1, key + "-");
    }

    // score 이상인 첫 위치 찾기 이분탐색
    int lowerBound(List<Integer> list, int target) {
        int left=0;
        int right=list.size();
        
        while(left<right){
            int mid=(left+right)/2;
            
            if(list.get(mid)<target){
                left=mid+1;
            } else right=mid;
        }
        
        return left;
    }
}