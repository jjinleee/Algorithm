import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime=fees[0];
        int basicFee=fees[1];
        int perTime=fees[2];
        int perFee=fees[3];
        
        Map<String, Integer> sumTime=new HashMap<>();
        Map<String, Integer> park=new HashMap<>();
        for(String r : records){
            String[] tmp=r.split(" ");
            int time=toTime(tmp[0]);
            String carnum=tmp[1];
            String type=tmp[2];
            
            if(type.equals("IN")){
                park.put(carnum, time);
            } else {
                int in=park.get(carnum);
                int totalTime=time-in;
                sumTime.put(carnum, sumTime.getOrDefault(carnum,0)+totalTime);
                park.remove(carnum);
            }
        }
        
        //출차내역없는 차
        if(!park.isEmpty()){
            for(String carnum : park.keySet()){
                int totalTime=23*60+59-park.get(carnum);                
                sumTime.put(carnum, sumTime.getOrDefault(carnum,0)+totalTime);
            }
        }
        
        //요금계산
        List<String> carNums=new ArrayList<>(sumTime.keySet());
        carNums.sort(Comparator.naturalOrder());
        int i=0;
        int[] answer=new int[carNums.size()];
        for(String c : carNums){
            int fee=basicFee;
            int totalTime=sumTime.get(c);
            
            if(totalTime>basicTime){
                int plus=totalTime-basicTime;
                fee+=(int)Math.ceil((double)plus/perTime)*perFee;
            }  
            answer[i++]=fee;
        }
        
        return answer;
    }
    int toTime(String t){
        String[] tmp=t.split(":");
        
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
}