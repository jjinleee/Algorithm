import java.util.*;

class Solution {
    class Plan{
        String name;
        int start;
        int playtime;
        
        Plan(String name, int start, int playtime){
            this.name=name;
            this.start=start;
            this.playtime=playtime;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> answer=new ArrayList<>();
        List<Plan> works=new ArrayList<>();
        for(String[] p : plans){
            String name=p[0];
            int start=toTime(p[1]);
            int playtime=Integer.parseInt(p[2]);
            
            works.add(new Plan(name, start, playtime));
        }
        
        works.sort((a,b)-> Integer.compare(a.start,b.start));
        Stack<Plan> stopped=new Stack<>();
        
        int n=plans.length;
        for(int i=0;i<n-1;i++){
            Plan cur=works.get(i);
            Plan next=works.get(i+1);
            
            int avail=next.start-cur.start;
            if(avail>=cur.playtime){ //바로종료
                answer.add(cur.name);
                avail-=cur.playtime;
                
                //멈춘거
                while(!stopped.isEmpty() && avail>0){
                    Plan stop=stopped.pop();
                    if(avail>=stop.playtime){
                        answer.add(stop.name);
                        avail-=stop.playtime;
                    } else {
                        stop.playtime-=avail;
                        stopped.push(stop);
                        avail=0;
                    }
                }
            } else { //도중에 중단
                cur.playtime-=avail;
                stopped.push(cur);

            }
        }
        //맨마지막거
        answer.add(works.get(n-1).name);
        
        //중단된거
        while(!stopped.isEmpty()){
            answer.add(stopped.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
    int toTime(String time){
        String[] tmp=time.split(":");
        
        return 60*Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]);
    }
}