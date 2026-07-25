import java.util.*;

class Solution {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> list= new ArrayList<>();
        
        for(int c : course){
            map=new HashMap<>();
            for(String order : orders){
                char[] sort=order.toCharArray();
                Arrays.sort(sort);
                order=String.valueOf(sort);
                dfs(order, c, "",0);
            }
            
            int max=0;
            for(String m : map.keySet()) max=Math.max(max, map.get(m));
            
            if(max<2) continue; //최소 2번이상 주문돼야함
            for(String m : map.keySet()){
                if(map.get(m)==max) list.add(m);
            }
        }
        
        list.sort((a,b)-> a.compareTo(b)); //사전순정렬
        
        return list.toArray(new String[0]);
    }
    void dfs(String order, int len, String cur, int idx){
        if(cur.length()==len){
            map.put(cur, map.getOrDefault(cur,0)+1);
            return;
        }
        if(idx>=order.length()) return;
        
        for(int i=idx;i<order.length();i++){
            dfs(order, len, cur+order.charAt(i), i+1);
        }
    }
}