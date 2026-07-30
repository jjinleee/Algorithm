import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {        
        //중복신고제거
        Set<String> set=new HashSet<>();
        for(String r : report){
            set.add(r);
        }
        Map<String,Integer> reported=new HashMap<>(); //신고당한사람, 신고횟수
        Map<String, List<String>> reporter=new HashMap<>(); //신고당한사람, 신고한 사람
        Map<String,Integer> mail=new HashMap<>(); //유저, 메일횟수
        for(String id : id_list) mail.put(id, 0);
        
        for(String s : set){
            String[] tmp=s.split(" ");
            reported.put(tmp[1],reported.getOrDefault(tmp[1],0)+1); //신고횟수증가
            reporter.computeIfAbsent(tmp[1], r->new ArrayList<>()).add(tmp[0]);
        }
        
        for(String stop : reported.keySet()){
            if(reported.get(stop)>=k){
                List<String> tomail=reporter.get(stop); //정지당한 유저 신고한 유저
                for(String m : tomail){ //메일 보냄
                    mail.put(m, mail.get(m)+1);
                }
            }
        }
        
        int[] answer= new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            answer[i]=mail.get(id_list[i]);
        }
        
        return answer;
    }
}