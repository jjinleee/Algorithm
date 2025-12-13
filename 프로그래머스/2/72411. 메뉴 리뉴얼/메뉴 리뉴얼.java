import java.util.*;

class Solution {
    Map<String,Integer> countMap=new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
        
        for(int c : course){
            countMap.clear();
            
            for(String order: orders){
                char[] arr=order.toCharArray();
                Arrays.sort(arr);
                dfs(arr,0,c,new StringBuilder());
            }
            
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
        
        for(int i=idx; i<arr.length;i++){
            sb.append(arr[i]);
            dfs(arr, i+1, targetLen, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}