import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        int[] nums= new int[n];
        HashMap<Integer,Integer> cnt=new HashMap<>();

        int sum=0;
        for(int i=0;i<n;i++){
            int number=Integer.parseInt(br.readLine());
            nums[i]=number;
            sum+=number;
            cnt.put(number, cnt.getOrDefault(number, 0)+1);
        }
        Arrays.sort(nums);

        int avg=(int) Math.round((double)sum/n);  //산술평균
        int mid=nums[n/2];  //중앙값(n은홀수)

        //최빈값, 여러개 있을땐 두번째로 작은값
        List<Map.Entry<Integer,Integer>> keyList=new ArrayList<>(cnt.entrySet());
        keyList.sort((o1,o2)-> {
            if(o1.getValue().equals(o2.getValue())){
                return Integer.compare(o1.getKey(), o2.getKey());
            }
            return Integer.compare(o2.getValue(), o1.getValue());
        });

        int mode;
        if (keyList.size() > 1 && keyList.get(0).getValue().equals(keyList.get(1).getValue())) {
            mode = keyList.get(1).getKey(); // 두 번째로 작은 최빈값 선택
        } else {
            mode = keyList.get(0).getKey(); // 단일 최빈값이면 그대로 반환
        }


        //범위:최대-최소
        int range=Math.abs(nums[n-1]-nums[0]);
        sb.append(avg).append("\n")
        .append(mid).append("\n")
        .append(mode).append("\n")
        .append(range);

        System.out.println(sb.toString());

    }       
}