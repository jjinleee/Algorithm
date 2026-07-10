import java.util.*;

class Solution {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
        
        for(int c : course){
            map=new HashMap<>();
            
            for(String order : orders){
                char[] arr=order.toCharArray();
                Arrays.sort(arr);
                
                dfs(arr,c,0,"");
            }
            
            int max=0;
            for(int count : map.values()){
                max=Math.max(max, count);
            }
            
            if(max<2) continue;
            for(String key : map.keySet() ){
                if(map.get(key)==max) answer.add(key);
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    void dfs(char[] arr, int len, int idx, String cur){
        if(cur.length()==len){
            map.put(cur, map.getOrDefault(cur,0)+1);
            return;
        }
        
        if(idx==arr.length) return;
        
        for(int i=idx;i<arr.length;i++){
            dfs(arr, len, i+1, cur+arr[i]);
        }
        
    }
}