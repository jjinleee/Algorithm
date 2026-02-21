import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> inMap=new HashMap<>();
        Map<Integer, Integer> totalMap=new HashMap<>();
        
        for(String r : records){
            String[] tmp=r.split(" ");
            int time=toMinute(tmp[0]);
            int car=Integer.parseInt(tmp[1]);
            String type=tmp[2];
            
            //출차
            if(type.equals("IN")){
                inMap.put(car, time);
            } else {
                totalMap.put(car, totalMap.getOrDefault(car,0)+time-inMap.get(car));
                inMap.remove(car);
            }
        }
        //출차기록없는 차 처리
        for(Map.Entry<Integer, Integer> entry : inMap.entrySet()){
            int car=entry.getKey();
            int inTime=entry.getValue();
            int diff=23*60+59-inTime;
            totalMap.put(car, totalMap.getOrDefault(car, 0) + diff);
        }
        //주차요금 계산
        int[] carNum=totalMap.keySet().stream().mapToInt(i->i).toArray();
        int[] answer= new int[carNum.length];
        
        Arrays.sort(carNum);
        int idx=0;
        for(int c : carNum){
            int use=totalMap.get(c);
            if(use<=fees[0]){
                answer[idx++]=fees[1];
            } else{
                int sum=fees[1];
                sum+=(int)Math.ceil((double)(use-fees[0])/fees[2])*fees[3];
                answer[idx++]=sum;
            }
        }
        
        
        return answer;
    }
    int toMinute(String t){
        int h=Integer.parseInt(t.split(":")[0]);
        int m=Integer.parseInt(t.split(":")[1]);
        
        return 60*h+m;
    }
}