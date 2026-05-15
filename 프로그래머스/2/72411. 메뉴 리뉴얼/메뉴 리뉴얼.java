import java.util.*;

class Solution {
    Map<String,Integer> map=new HashMap<>(); //조합별 주문횟수
    public String[] solution(String[] orders, int[] course) {
        List<String> list=new ArrayList<>();
        
        for(int c : course){
            map.clear();
            
            for(String order : orders){
                char[] arr= order.toCharArray();
                Arrays.sort(arr);
                dfs(arr, 0, c, new StringBuilder());
            }
            
            //최대횟수조합
            int max=0;
            for(int v : map.values()){
                if(v>=2) max=Math.max(max, v);
            }
            
            for(Map.Entry<String,Integer> e : map.entrySet()){
                if(e.getValue()==max && max>=2) list.add(e.getKey());
            }
        }
        Collections.sort(list);

    
    
        return list.toArray(new String[0]);
    }
    void dfs(char[] arr, int idx, int max, StringBuilder sb){
        if(sb.length()==max){
            String key=sb.toString();
            map.put(key, map.getOrDefault(key,0)+1);
            return;
        }
        
        for(int i=idx; i<arr.length;i++){
            sb.append(arr[i]);
            dfs(arr, i+1, max, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}