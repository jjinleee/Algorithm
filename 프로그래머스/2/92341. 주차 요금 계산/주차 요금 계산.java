import java.util.*;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        int n=records.length;
        int basicTime=fees[0];
        int basic=fees[1];
        int per=fees[2];
        int perFee=fees[3];
        
        Map<Integer,Integer> totalTime=new HashMap<>(); //차번호, 누적시간 
        Map<Integer,Integer> inTime=new HashMap<>(); //차번호, 입차시간 
            
        //차량별 누저시간 계산
        for(String r : records){
            String[] tmp=r.split(" ");
            int time=toMin(tmp[0]);
            int num=Integer.parseInt(tmp[1]);
            String exist= tmp[2];
            
            if(exist.equals("IN")){ //입차
                inTime.put(num, time);
            } else { //출차
                int use=time-inTime.get(num); //이용시간계산
                totalTime.put(num, totalTime.getOrDefault(num,0)+use);
                inTime.remove(num); //입차기록 삭제
            }
        }
    
        //출차기록 없는 차 처리
        if(!inTime.isEmpty()){
            for(int car : inTime.keySet()){
                int in=inTime.get(car);
                int use=23*60+59-in;
                totalTime.put(car, totalTime.getOrDefault(car, 0)+use );
            }
        }
        
        Map<Integer, Integer> totalMoney=new HashMap<>();//차량별 총 요금
        
        //요금계산
        for(int car : totalTime.keySet()){
            int money=basic;
            int used=totalTime.get(car);
            
            //기본시간 초과
            if(used>basicTime){
                int extra=used-basicTime;
                money+=(int)Math.ceil((double)extra/per) *perFee; //올림
            }
            totalMoney.put(car, money);
        }
        
        //차량번호 오름차순으로 요금 리턴
        List<Integer> sorted=new ArrayList<>(totalMoney.keySet());
        Collections.sort(sorted);
        int idx=0;
        int[] answer=new int[sorted.size()];
        for(int s : sorted) answer[idx++]=totalMoney.get(s);
        
        
        return answer;
    }
    int toMin(String s){
        int h=Integer.parseInt(s.split(":")[0]);
        int m=Integer.parseInt(s.split(":")[1]);
        
        return 60*h+m;
    }
}