import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //각 유저별 메일횟수저장(map은 순서보장이 안됨)
        Map<String,Integer> users=new HashMap<>();
        for(String id : id_list){
            users.put(id,0);
        }
        //신고당한 사람별 신고한 사람 목록(한사람의 동일 유저 중복신고안됨->Set사용)
        Map<String,Set<String>> reported=new HashMap<>();
        for(String r : report){
            String reportPerson=r.split(" ")[0];
            String reportedPerson=r.split(" ")[1];
            reported.putIfAbsent(reportedPerson,new HashSet<>());
            reported.get(reportedPerson).add(reportPerson);
        }
        
        //k번이상 신고됐는지 체크
        for(String s : reported.keySet()){
            //정지된 유저를 신고한 유저에게 메일
            if(reported.get(s).size()>=k){
                Set<String> mail=reported.get(s);
                for(String name : mail){
                    users.put(name,users.get(name)+1);
                }
            }
        }
        
        int[] answer=new int[id_list.length];
        int y=0;
        for(String id : id_list){
            answer[y++]=users.get(id);
        }
        
        return answer;
    }
}