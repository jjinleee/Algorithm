import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n=id_list.length;
        int[] answer = new int[n];
        Map<String, Integer> reported=new HashMap<>(); //유저별 신고당한횟수
        Map<String,List<String>> reporter=new HashMap<>(); //유저별 신고한 유저
        Map<String,List<String>> reporters=new HashMap<>(); //유접별 신고이력
        //순서유지하려면 treemap
        for(String id : id_list) reporters.put(id, new ArrayList<>());
        
        //한 유저가 여러번 신고한 경우 제거
        Set<String> set=new HashSet<>();
        for(String r : report) set.add(r);
        
        for(String r : set){
            String[] tmp=r.split(" ");
            String a=tmp[0];
            String b=tmp[1];
            
            reported.put(b,reported.getOrDefault(b,0)+1);
            reporter.computeIfAbsent(b,j->new ArrayList<>()).add(a);
            reporters.get(a).add(b); 
        }
        
        //정지 유저
        List<String> stop=new ArrayList<>();
        for(String p : reported.keySet()){
            if(reported.get(p)>=k) stop.add(p);
        }
        
        //발송메일 카운트
        int idx=0;
        for(String p : id_list){
            List<String> list=reporters.get(p);
            int cnt=0;
            for(String l : list){
                if(stop.contains(l)) cnt++;
            }
            
            answer[idx++]=cnt;
        }
        return answer;
    }
}