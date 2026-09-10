import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime=fees[0];
        int basicFee=fees[1];
        int plusTime=fees[2];
        int plusFee=fees[3];
        
        Map<Integer, Integer> totalTime=new HashMap<>();
        Map<Integer, Integer> inCar=new HashMap<>();
        
        for(String r : records){
            String[] tmp=r.split(" ");
            int time=toMin(tmp[0]);
            int carNum=Integer.parseInt(tmp[1]);
            String order=tmp[2];
            
            if(order.equals("IN")){
                inCar.put(carNum, time);
            }else{
                int during=time-inCar.get(carNum); //사용시간
                totalTime.put(carNum, totalTime.getOrDefault(carNum,0)+during);
                inCar.remove(carNum);
            }
        }
        //출차내역없는차
        if(!inCar.isEmpty()){
            for(int carNum : inCar.keySet()){
                int during=23*60+59-inCar.get(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum,0)+during);
            }
        }
        
        //비용계산
        List<Integer> car=new ArrayList<>(totalTime.keySet());
        Collections.sort(car); //오름차순정렬
        int[] answer=new int[car.size()];
        
        int idx=0;
        for(int c : car){
            int usedTime=totalTime.get(c);
            int pay=basicFee;
            if(usedTime>basicTime){
                double remain=usedTime-basicTime;
                int add=(int)(Math.ceil(remain/plusTime))*plusFee;
                answer[idx++]=pay+add;
            } else answer[idx++]=pay;
        }
        
        return answer;
    }
    int toMin(String time){
        String[] tmp=time.split(":");
        int h=Integer.parseInt(tmp[0])*60;
        int m=Integer.parseInt(tmp[1]);
        
        return h+m;
        
    }
}