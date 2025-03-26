import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  
        int n=Integer.parseInt(br.readLine());

        int[] nums= new int[n];
        int[] cnt=new int[8001];        
        int sum=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int k=Integer.parseInt(br.readLine());
            nums[i]=k;
            sum+=k;
            cnt[k+4000]++;
            max=Math.max(max, k);
            min=Math.min(min,k);
        }

        Arrays.sort(nums);

        int mean=Math.round((float)sum/n);
        int median= nums[n/2];
        int modeMax=0;

        for(int c:cnt){
            if(c>modeMax) modeMax=c;
        }

        List<Integer> modes= new ArrayList<>();
        for(int i=0;i<8001;i++){
            if(cnt[i]==modeMax){
                modes.add(i-4000);
            }
        }
        int mode = modes.size() > 1 ? modes.get(1) : modes.get(0);
        int range=max-min;

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}