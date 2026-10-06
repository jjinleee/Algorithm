import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer> totalTime=new HashMap<>(); //차량별 누적시간
        Map<Integer,Integer> carIn=new HashMap<>(); //차량별입차시간
        int basicTime=fees[0];
        int basicFee=fees[1];
        int extraTime=fees[2];
        int extraFee=fees[3];
        
        for(String r : records){
            String[] tmp=r.split(" ");
            int time=toTime(tmp[0]);
            int carNum=Integer.parseInt(tmp[1]);
            String c=tmp[2];
            
            if(c.equals("IN")){
                carIn.put(carNum, time);
            } else {
                int start=carIn.get(carNum);
                int used=time-start;
                totalTime.put(carNum, totalTime.getOrDefault(carNum,0)+used);
                carIn.remove(carNum);
            }
        }
        //출차내역없는 차 처리
        for(int c : carIn.keySet()){
            int used=23*60+59-carIn.get(c);
            totalTime.put(c, totalTime.getOrDefault(c,0)+used);
        }
        
        List<Integer> carNums=new ArrayList<>(totalTime.keySet());
        Collections.sort(carNums);
        int idx=0;
        int[] answer=new int[carNums.size()];
        
        for(int car : carNums){
            int totalUsed=totalTime.get(car);
            if(totalUsed<=basicTime){
                answer[idx++]=basicFee;
            } else {
                int add=totalUsed-basicTime;
                int addmoney=(int)Math.ceil((double)add/extraTime)* extraFee;
                answer[idx++]=basicFee+addmoney;
            }
        }
        
        
        return answer;
    }
    int toTime(String t){
        String[] tmp=t.split(":");
        
        return 60*Integer.parseInt(tmp[0])+Integer.parseInt(tmp[1]);
    }
}