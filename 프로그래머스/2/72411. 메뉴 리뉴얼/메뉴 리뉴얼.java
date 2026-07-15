import java.util.*;

class Solution {
    Map<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer=new ArrayList<>();
        
        for(int c : course){
            map=new HashMap<>();
            
            for(String order :orders){
                char[] tmp=order.toCharArray();
                Arrays.sort(tmp);
                dfs(c, new String(tmp), "", 0);
            }
            
            int max=0;
            for(String m : map.keySet()){
                if(max<map.get(m)) max=map.get(m);
            }
            
            if(max<2) break; //최소2명이상 손님으로부터 주문되어야함
            
            for(String m : map.keySet()){
                if(map.get(m)==max){
                    answer.add(m);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    void dfs(int max, String order, String cur, int idx){
        if(max==cur.length()){
            map.put(cur, map.getOrDefault(cur,0)+1);
            return;
        }
        if(idx==order.length()) return;
        
        for(int i=idx;i<order.length();i++){
           dfs(max, order, cur+order.charAt(i),i+1);
        }
        
    }
}