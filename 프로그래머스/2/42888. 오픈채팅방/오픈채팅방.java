import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String[]> order= new ArrayList<>();
        HashMap<String,String> user=new HashMap<>();
        
        for(String log:record){
            String[] temp=log.split(" ");
            String action=temp[0];
            String id=temp[1];
            
            if(action.equals("Enter")||action.equals("Change")){
                String nickname=temp[2];
                user.put(id,nickname);
            }
            if(!action.equals("Change")){
                order.add(new String[]{id,action});
            }
        }
        
        String[] result= new String[order.size()];
        int i=0;
        for(String[] msg:order){
            String id=msg[0];
            String action=msg[1];
            String nickname=user.get(id);
            
            if(action.equals("Enter")){
                result[i++]=nickname+"님이 들어왔습니다.";
            } else if(action.equals("Leave")){
                result[i++]=nickname+"님이 나갔습니다.";
            }
        }
        
        return result;
    }
}