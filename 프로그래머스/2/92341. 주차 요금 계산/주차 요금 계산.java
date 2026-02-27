import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer> car=new HashMap<>();
        Map<Integer,Integer> total=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        
        for(String r : records){
            String time=r.split(" ")[0];
            int carNum=Integer.parseInt(r.split(" ")[1]);
            
            //출차
            if(car.containsKey(carNum)){
                int spend=toMinuite(time)-car.get(carNum);
                total.put(carNum, total.getOrDefault(carNum,0)+spend);
                car.remove(carNum);
            } else car.put(carNum, toMinuite(time)); //입차
            
        }
        //출차가 안찍힌차 처리
        for(int carNum: car.keySet()){
            int spend=23*60+59-car.get(carNum);
            total.put(carNum, total.getOrDefault(carNum,0)+spend);
        }
        
        List<Integer> order=new ArrayList<>(total.keySet());
        Collections.sort(order);
        for(int c : order){
            int time=total.get(c);
            if(time<=fees[0]) list.add(fees[1]);
            else{
                int extra=time-fees[0];
                int cost=fees[1]+(int)Math.ceil((double)extra/fees[2])*fees[3];
                list.add(cost);
            }
        }
        
        int[] answer= new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i]=list.get(i);
        
        return answer;
    }
    int toMinuite(String time){
        int h=Integer.parseInt(time.split(":")[0]);
        int m=Integer.parseInt(time.split(":")[1]);
        
        return 60*h+m;
    }
}