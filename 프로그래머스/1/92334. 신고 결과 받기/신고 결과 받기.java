import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n=id_list.length;
        int[] answer = new int[n];
        
        Map<String,Set<String>> reporting=new HashMap<>();
        for(int i=0;i<n;i++){
            reporting.put(id_list[i],new HashSet<>());
        }
        Map<String,Integer> reported= new HashMap<>();
        for(String r: report){
            String[] tmp=r.split(" ");
            String from=tmp[0];
            String to=tmp[1];
            
            if(reporting.get(from).add(to)){
                reported.put(to, reported.getOrDefault(to,0)+1);
            }
        }
        
        for(int i=0;i<n;i++){
            String user=id_list[i];
            int cnt=0;
            
            for(String target : reporting.get(user)){
                if(reported.getOrDefault(target,0)>=k) cnt++;
            }
            answer[i]=cnt;
        }
        
        
        return answer;
    }
}