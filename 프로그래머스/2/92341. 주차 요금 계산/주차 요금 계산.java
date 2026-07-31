import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime=fees[0];
        int basicFee=fees[1];
        int plusTime=fees[2];
        int plusFee=fees[3];
        
        Map<Integer, Integer> startTime=new HashMap<>(); //차량입차시간
        Map<Integer, Integer> total=new HashMap<>(); //차량별 누적시간
        for(String r : records){
            String[] tmp=r.split(" ");
            int time=Integer.parseInt(tmp[0].split(":")[0])*60+ Integer.parseInt(tmp[0].split(":")[1]);
            int car=Integer.parseInt(tmp[1]);
            String cmd=tmp[2];
            
            if(cmd.equals("IN")){
                startTime.put(car, time);
            } else {
                int start=startTime.get(car);
                int during=time-start;
                total.put(car, total.getOrDefault(car,0)+during); //누적
                startTime.remove(car);
            }
        }
        
        //출차내역없는 차 처리
        if(!startTime.isEmpty()){
            for(int car : startTime.keySet()){
                int during=23*60+59-startTime.get(car);
                total.put(car, total.getOrDefault(car,0)+during);
            }
        }
        
        //차량 번호 작은 차부터
        List<Integer> list=new ArrayList<>(total.keySet());
        list.sort(Comparator.naturalOrder());
        
        int[] answer=new int[list.size()];
        int idx=0;
        for(int l : list){
            int totalTime=total.get(l);
            int money=basicFee;
            if(totalTime>basicTime){
                float plus=totalTime-basicTime;
                int plusmoney=(int)Math.ceil(plus/plusTime)*plusFee;
                money+=plusmoney;
            }
            answer[idx++]=money;
        }
        
        return answer;
    }
}