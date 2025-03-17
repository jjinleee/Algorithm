import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //신고당한, 신고한
        Map<String, HashSet<String>> reportMap= new HashMap<>();
        //유저별 메일개수
        Map<String,Integer> mail=new HashMap<>();
        
        for(String id: id_list){
            reportMap.put(id, new HashSet<>());
            mail.put(id,0);
        }
        
        for(String s: report){
            String[] temp= s.split(" ");
            String reporter=temp[0];
            String reported=temp[1];
            reportMap.get(reported).add(reporter);
        }
        
        for(String reported:reportMap.keySet()){
            if(reportMap.get(reported).size()>=k){
                for(String reporter: reportMap.get(reported)){
                    mail.put(reporter, mail.get(reporter)+1);
                }
            }
        }
        
        int[] result=new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            result[i]=mail.get(id_list[i]);
        }
        
        return result;
    }
}