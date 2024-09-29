import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        int[] nums= new int[N];
        Map<Integer, Integer> time=new HashMap<>();
        int sum=0;

        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(br.readLine());
            sum+=nums[i];
            time.put(nums[i], time.getOrDefault(nums[i], 0)+1);
        }
        Arrays.sort(nums);

        StringBuilder sb=new StringBuilder();
        //산술평균
        double mean=(double)sum/N;
        sb.append(Math.round(mean)+"\n");
        //중앙값
        sb.append(nums[N/2]+"\n");
        //최빈값
        List<Map.Entry<Integer, Integer>> timeList=new ArrayList<>(time.entrySet());
        timeList.sort((a,b)->{
            if(b.getValue().equals(a.getValue())){
                return Integer.compare(a.getKey(), b.getKey());
            }
            return Integer.compare(b.getValue(), a.getValue());
        });

        if(timeList.size()>1 && timeList.get(0).getValue().equals(timeList.get(1).getValue())){
            sb.append(timeList.get(1).getKey()+"\n");
        } else sb.append(timeList.get(0).getKey()+"\n");
        //범위
        //양수,음수
        sb.append(nums[N-1]-nums[0]);

        System.out.println(sb.toString());

    }
}