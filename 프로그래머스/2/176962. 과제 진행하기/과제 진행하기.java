import java.util.*;

class Solution {
    class Plan{
        String name;
        int start;
        int remain;
        
        Plan(String name,int start,int remain){
            this.name=name;
            this.start=start;
            this.remain=remain;
        }
    }
    public String[] solution(String[][] plans) {
        Stack<Plan> stopped=new Stack<>();        
        Arrays.sort(plans, (a,b)-> a[1].compareTo(b[1]));
        
        int n=plans.length;
        String[] answer = new String[n];
        int idx=0;
        
        for(int i=0;i<n-1;i++){
            Plan cur=new Plan(plans[i][0],toTime(plans[i][1]), Integer.parseInt(plans[i][2]));
            Plan next=new Plan(plans[i+1][0],toTime(plans[i+1][1]), Integer.parseInt(plans[i+1][2]));
            int avail=next.start-cur.start;
            
            if(cur.remain<=avail){ //바로완료
                answer[idx++]=cur.name;
                avail-=cur.remain;  
                
                //중단했던 과제
                while(!stopped.isEmpty() && avail>0){
                    Plan stop=stopped.pop();
                    if(stop.remain<=avail){
                        avail-=stop.remain;
                        answer[idx++]=stop.name;
                    } else {
                        stop.remain-=avail;
                        stopped.push(stop);
                        avail=0; 
                    }
                }
                
            } else{ //중단
                cur.remain-=avail;
                stopped.push(cur);
            }
        }
        
        //마지막 과제
        answer[idx++]=plans[n-1][0];
        
        //중단했던과제 모두 완료
        while(!stopped.isEmpty()){
            answer[idx++]=stopped.pop().name;
        }
        
        
        return answer;
    }
    int toTime(String t){
        String[] tmp=t.split(":");
        
        return  60*Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]);
    }
}