import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> nickname=new HashMap<>();
        List<String> messages=new ArrayList<>();
        
        for(String r : record){
            String[] tmp=r.split(" ");
            String type=tmp[0];
            if(type.equals("Enter") || type.equals("Change")){
                nickname.put(tmp[1],tmp[2]);    
            }             
            if(type.equals("Enter") || type.equals("Leave")) messages.add(tmp[0]+" "+tmp[1]);
        }
        
        String[] answer=new String[messages.size()];
        for(int i=0;i<messages.size();i++){
            String [] tmp=messages.get(i).split(" ");
            String type=tmp[0];
            String uid=tmp[1];
            if(type.equals("Enter")) answer[i]=nickname.get(uid)+"님이 들어왔습니다.";
            else answer[i]=nickname.get(uid)+"님이 나갔습니다.";
        }
        return answer;
    }
}