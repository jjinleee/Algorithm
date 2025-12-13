import java.util.*;

class Solution {
    Map<String,Integer> countMap=new HashMap<>(); //조합별, 횟수
    public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
        
        for(int c : course){ //길이만큼 조합
            countMap.clear();
            
            for(String order: orders){ //각 주문에서 만들수 있는 조합
                char[] arr=order.toCharArray();
                Arrays.sort(arr); //정렬먼저
                dfs(arr,0,c,new StringBuilder());
            }
            
            //최대횟수조합 찾기
            int max=0;
            for(int v : countMap.values()){
                if(v>=2) max=Math.max(max,v);
            }
            
            for(Map.Entry<String,Integer> e : countMap.entrySet()){
                if(e.getValue()==max && max>=2) answer.add(e.getKey());
            }
        }

        Collections.sort(answer);
        
        
        return answer.toArray(new String[0]);
    }
    void dfs(char[] arr, int idx, int targetLen, StringBuilder sb){
        if(sb.length()==targetLen){
            String key=sb.toString();
            countMap.put(key, countMap.getOrDefault(key,0)+1);
            return;
        }
        
        for(int i=idx; i<arr.length;i++){ //idx부터 시작하는게 핵심
            sb.append(arr[i]);
            dfs(arr, i+1, targetLen, sb);
            sb.deleteCharAt(sb.length()-1); //이게 들어가야 다른 조합도 모두 찾을 수 있음(다음 i로 넘어가서 다른선택)
        }
    }
}