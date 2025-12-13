import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n=id_list.length;
        int[] answer = new int[n];
        
        //유저별 신고목록
        Map<String,Set<String>> reporting=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            reporting.put(id_list[i],new HashSet<>());
        }
        //신고당한 목록
        Map<String,Integer> reported=new HashMap<>();      
        
        //신고이력정리
        for(String r : report){
            String[] tmp=r.split(" ");
            String a=tmp[0];
            String b=tmp[1];
            
            reporting.get(a).add(b);
        }
        //신고횟수카운트
        for(String p : reporting.keySet()){
            Set<String> tmp=reporting.get(p);
            for(String t : tmp){
                reported.put(t,reported.getOrDefault(t,0)+1);
            }
        }
        //정지된회원
        List<String> stop=new ArrayList<>();
        for(String r : reported.keySet()){
            if(reported.get(r)>=k) stop.add(r);
        }
        
        int i=0;
        for(String p : reporting.keySet()){
            int cnt=0;
            Set<String> tmp=reporting.get(p);
            for(String s : stop){
                if(tmp.contains(s)) cnt++;
            }
            answer[i++]=cnt;
        }
        
        
        return answer;
    }
}