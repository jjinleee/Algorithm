import java.util.*;

class Solution {
    class Plan{
        String name;
        int start;
        int remain;
        
        Plan(String name, int start,  int remain){
            this.name=name;
            this.start=start;
            this.remain=remain;
        }
    }
    public String[] solution(String[][] plans) {
        int n=plans.length;
        String[] answer = new String[n];
        Stack<Plan> stop=new Stack<>();
        
        List<Plan> list=new ArrayList<>();
        for(String[] p : plans) list.add(new Plan(p[0],toTime(p[1]),Integer.parseInt(p[2])));
        list.sort((a,b)-> a.start-b.start); //시작시간 순 정렬
        
        int idx=0;
        for(int i=0;i<n-1;i++){
            Plan cur=list.get(i);
            Plan next=list.get(i+1);
            int avail= next.start-cur.start;
            
            if(avail>=cur.remain){ //바로완료
                answer[idx++]=cur.name;
                avail-=cur.remain;
                
                //중단된 과제
                while(avail>0 && !stop.isEmpty()){
                    Plan stopped=stop.pop();
                    if(stopped.remain<=avail){
                        answer[idx++]=stopped.name;
                        avail-=stopped.remain;
                    } else {
                        stopped.remain-=avail;
                        stop.push(stopped);
                        avail=0;
                    }
                }
            } else { //과제 중단
                cur.remain-=avail;
                avail=0;
                stop.push(cur);
            }
        }
        answer[idx++]=list.get(n-1).name;
        
        while(!stop.isEmpty()){
            answer[idx++]=stop.pop().name;
        }
        
        return answer;
    }
    int toTime(String t){
        String[] tmp=t.split(":");
        
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
}